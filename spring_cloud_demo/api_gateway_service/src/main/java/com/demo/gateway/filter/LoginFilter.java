package com.demo.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自动以一个全局过滤器
 * 实现两个接口
 */
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    /**
     * 执行过滤逻辑
     * 对请求头中的access-tokens的参数进行验证
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("执行了过滤器lallal");
        String token = exchange.getRequest().getQueryParams().getFirst("access-tokens");
        if (token == null) {
            System.out.println("认证失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        System.out.println("认证成功");
        return chain.filter(exchange);
    }

    /**
     * 制定过滤器的执行顺序，返回值越小 优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
