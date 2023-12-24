package eu.wspaniali.collector.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Connection;
import eu.wspaniali.collector.card.CardController;
import eu.wspaniali.collector.card.CardService;
import io.magicthegathering.javasdk.resource.Card;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Receiver;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

class CardSubscriber {

    private static final String QUEUE = "card-q";

    private static final Logger logger = LogManager.getLogger(CardController.class);

    private final CardService cardService;
    private final ObjectMapper mapper;
    private final Mono<Connection> connectionMono;
    private final Receiver receiver;

    public CardSubscriber(CardService cardService, ObjectMapper mapper,
                          Mono<Connection> connectionMono, Receiver receiver) {
        this.cardService = cardService;
        this.mapper = mapper;
        this.connectionMono = connectionMono;
        this.receiver = receiver;
    }

    @PostConstruct
    private void init() {
        receiver.consumeAutoAck(QUEUE).subscribe(message -> {
            try {
                String json = new String(message.getBody(), StandardCharsets.UTF_8);

                Card card = mapper.readValue(json, Card.class);
                logger.info("Received card {}", card.getName());
                cardService.store(Mono.just(card));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @PreDestroy
    public void close() throws Exception {
        Objects.requireNonNull(connectionMono.block())
            .close();
    }

}
