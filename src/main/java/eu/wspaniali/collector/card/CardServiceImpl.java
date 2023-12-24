package eu.wspaniali.collector.card;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import io.magicthegathering.javasdk.resource.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.util.stream.Collectors;

public class CardServiceImpl implements CardService {

    private static final Logger log = LogManager.getLogger(CardServiceImpl.class);
    private static final String CARDS_INDEX = "cards";
    private final ElasticsearchClient esClient;

    public CardServiceImpl(ElasticsearchClient esClient) {
        this.esClient = esClient;
    }

    @Override
    public Flux<Card> searchCards(String keyword) {
        return Mono.fromCallable(() -> {
                SearchResponse<Card> search = search(keyword);
                return search.hits()
                    .hits().stream()
                    .map(Hit::source)
                    .collect(Collectors.toList());
            })
            .flatMapMany(Flux::fromIterable)
            .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Card> store(Mono<Card> cardMono) {
        return cardMono.flatMap(card -> {
            IndexRequest<Card> request = IndexRequest.of(i -> i
                .index(CARDS_INDEX)
                .id(card.getId())
                .document(card)
            );

            try {
                esClient.index(request);
                log.info("Stored card with name: " + card.getName());
                return Mono.just(card);
            } catch (IOException e) {
                log.error(e.getMessage());
                return Mono.error(new RuntimeException(e));
            }
        }).subscribeOn(Schedulers.boundedElastic());
    }

    private SearchResponse<Card> search(String keyword) {
        SearchRequest of = SearchRequest.of(s -> s
            .index("cards")
            .query(q -> q
                .match(t -> t
                    .field("name")
                    .query(keyword))));

        try {
            return esClient.search(of, Card.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
