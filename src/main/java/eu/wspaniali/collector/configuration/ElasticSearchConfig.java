package eu.wspaniali.collector.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    private final String elasticsearchAddress;

    public ElasticSearchConfig(@Value("${elasticsearch.connection.address}") String address) {
        this.elasticsearchAddress = address;
    }

    @Bean
    ElasticsearchClient elasticSearchClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost(elasticsearchAddress, 9200))
            .build();

        RestClientTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(transport);
    }
}
