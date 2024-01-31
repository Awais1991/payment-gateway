package org.assessment.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("student", r -> r.path("/student/**")
                        .uri("http://localhost:8081/student"))
                .route("fee", r -> r.path("/fee/**")
                        .uri("http://localhost:8082/fee"))
                .route("payment", r -> r.path("/payment/**")
                        .uri("http://localhost:8083/payment"))
                .route("document", r -> r.path("/document/**")
                        .uri("http://localhost:8083/document"))
                // Add more routes as needed
                .build();
    }
}
