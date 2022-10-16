package com.ajd.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ajd.cloud.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
				.route("Client", r -> r.path("/clients/**").filters(f -> f.filter(filter)).uri("lb://Client"))
				.route("Product", r -> r.path("/products/**").filters(f -> f.filter(filter)).uri("lb://Product"))
				.route("ClientUpdate", r -> r.path("/updateClients/**").filters(f -> f.filter(filter)).uri("lb://ClientUpdate"))
				.route("ProductUpdate", r -> r.path("/productUpdate/**").filters(f -> f.filter(filter)).uri("lb://ProductUpdate"))
				.route("Image", r -> r.path("/image/**").filters(f -> f.filter(filter)).uri("lb://Image"))
				.route("SearchProduct", r -> r.path("/searchProducts/**").filters(f -> f.filter(filter)).uri("lb://SearchProduct"))
				.route("ClientSearch", r -> r.path("/searchClients/**").filters(f -> f.filter(filter)).uri("lb://ClientSearch"))
				.build();
	}

}
