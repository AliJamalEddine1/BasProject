package com.ajd.cloud.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.ajd.cloud.exception.JwtTokenMalformedException;
import com.ajd.cloud.exception.JwtTokenMissingException;
import com.ajd.cloud.util.JwtUtil;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GatewayFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();

		final List<String> apiEndpoints = new ArrayList<String>();
apiEndpoints.add("/auth/register");apiEndpoints.add("/auth/login");
apiEndpoints.add("/auth/refresh");apiEndpoints.add("/products/allproduct");
apiEndpoints.add("/image/getAll");apiEndpoints.add("/image/getPublicImage");
apiEndpoints.add("/products/search");apiEndpoints.add("/searchClients/searchPhoneNumber");
		Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
				.noneMatch(uri -> r.getURI().getPath().contains(uri));

		if (isApiSecured.test(request)) {
			if (!request.getHeaders().containsKey("Authorization")) {
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);

				return response.setComplete();
			}

			final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

			try {
				jwtUtil.validateToken(token);
			} catch (JwtTokenMalformedException | JwtTokenMissingException e) {
				// e.printStackTrace();

				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.BAD_REQUEST);

				return response.setComplete();
			}

			Claims claims = jwtUtil.getClaims(token);
			exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
		}

		return chain.filter(exchange);
	}

}
