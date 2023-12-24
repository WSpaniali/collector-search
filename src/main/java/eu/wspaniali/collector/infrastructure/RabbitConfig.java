package eu.wspaniali.collector.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import eu.wspaniali.collector.card.CardConfig;
import eu.wspaniali.collector.card.CardService;
import eu.wspaniali.collector.configuration.DeserializationConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;

@Configuration
public class RabbitConfig {

    private final CardService cardService;
    private final ObjectMapper objectMapper;


    public RabbitConfig(CardConfig cardConfig, DeserializationConfig deserializationConfig) {
        this.cardService = cardConfig.cardService();
        this.objectMapper = deserializationConfig.objectMapper();
    }

    @Bean
    Mono<Connection> rabbitConnection() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.useNio();
        return Mono.fromCallable(() -> connectionFactory.newConnection("receiver-connection"))
            .cache();
    }

    @Bean
    public ReceiverOptions receiverOptions(Mono<Connection> connectionMono) {
        return new ReceiverOptions()
            .connectionMono(connectionMono);
    }

    @Bean
    Receiver receiver(ReceiverOptions receiverOptions) {
        return RabbitFlux.createReceiver(receiverOptions);
    }

    @Bean
    CardSubscriber cardSubscriber(Mono<Connection> rabbitConnection, Receiver receiver) {
        return new CardSubscriber(cardService, objectMapper, rabbitConnection, receiver);
    }
}
