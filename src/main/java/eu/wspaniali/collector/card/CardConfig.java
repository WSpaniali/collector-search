package eu.wspaniali.collector.card;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardConfig {

    private final ElasticsearchClient elasticsearchClient;

    public CardConfig(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Bean
    public CardService cardService() {
        return new CardServiceImpl(elasticsearchClient);
    }

}
