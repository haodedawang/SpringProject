package com.demo.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfiguration {
    /**
     * 编写基于请求路径的限流规则
     * //abc
     * // 基于请求ip
     * //基于参数 等等很多种
     *
     * @return
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        return new KeyResolver() {

            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //将请求路径作为redis离得resolver key
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    /**
     * 基于请求参数限流
     * @return
     */
//    @Bean
//    public KeyResolver userKeyResilver() {
//        return exchange -> Mono.just(
//                exchange.getRequest().getQueryParams().getFirst("userId")//基于请求参数
//                exchange.getRequest().getHeaders().getFirst("X-Forword-For")//基于ip
//        );
//    }
}
