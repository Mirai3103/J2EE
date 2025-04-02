package sgu.demo.gateway;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class MinuteBasedRoutePredicateFactory extends AbstractRoutePredicateFactory<MinuteBasedRoutePredicateFactory.Config> {

    public MinuteBasedRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            int currentMinute = LocalDateTime.now().getMinute();
            return config.evenMinute == (currentMinute % 2 == 0);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("evenMinute");
    }

    @Setter
    @Getter
    public static class Config {
        private boolean evenMinute;

    }
}