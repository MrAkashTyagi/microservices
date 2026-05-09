package com.bigsquare.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//public class CustomRouteLocator {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//
//        return routeLocatorBuilder.routes()
//                .route("USER-SERVICE", r -> r.path("/users/**")
//                        .uri("lb://USER-SERVICE"))
////                .route("USER-SERVICE", r->r.path("/users/**")
////                .uri("lb://USER-SERVICE"))
//                .route("HOTEL-SERVICE",r->r.path("/hotels/**").uri("lb://HOTEL-SERVICE"))
//                .route("RATING-SERVICE", r->r.path("/ratings/**").uri("lb://RATING-SERVICE")).build();
//
//    }
//
//}
