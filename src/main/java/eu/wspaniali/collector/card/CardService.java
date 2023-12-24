package eu.wspaniali.collector.card;

import io.magicthegathering.javasdk.resource.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

    Flux<Card> searchCards(String keyword);

    Mono<Card> store(Mono<Card> cardMono);
}
