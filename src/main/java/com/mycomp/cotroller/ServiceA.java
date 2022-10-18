package com.mycomp.cotroller;


import com.mycomp.model.PingResponse;
import com.mycomp.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.*;
import java.time.Duration;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
@Slf4j
public class ServiceA {

   private WebClient webClient;


   private RestTemplate restTemplate = new RestTemplate();


   @Value("${base-url}")
    private  String baseUrl;

    ServiceA(WebClient client){
        this.webClient = client;
    }


    @GetMapping("/ping")
//    @PreAuthorize("has")
    public ResponseEntity<PingResponse> ping(@RegisteredOAuth2AuthorizedClient("myservicesab2") OAuth2AuthorizedClient authorizedClient) throws IOException, URISyntaxException {
        log.debug("Invoked ping()");
        PingResponse responseBuilder = new PingResponse();
        responseBuilder.setHostName(InetAddress.getLocalHost().getHostName());
        responseBuilder.setIpAddress(Util.getLocalIPAddress());
        responseBuilder.setResponse(this.getClass().getCanonicalName());
        responseBuilder.setNextResponse(getServiceBResponse(authorizedClient));
//        responseBuilder.setNextResponse(this.webClient.get().uri("/pingB").retrieve().bodyToMono(PingResponse.class).block());
//        URI uri = new URI(baseUrl);
//        ResponseEntity<PingResponse> responseB = restTemplate.getForEntity(baseUrl, PingResponse.class);
//        if(responseB.getStatusCode().is2xxSuccessful()){
//            responseBuilder.setNextResponse(responseB.getBody());
//        }
        log.debug("Completed ping()");
        return ResponseEntity.ok(responseBuilder);
    }

    private PingResponse getServiceBResponse(OAuth2AuthorizedClient authorizedClient){
        log.debug("Reading response from ServiceB");
        PingResponse response = null;
        try {
            response = this.webClient.get().uri("/pingB").attributes(oauth2AuthorizedClient(authorizedClient)).retrieve().bodyToMono(PingResponse.class).block(Duration.ofMinutes(1));
        }catch(Throwable e){
            log.error(e.getMessage(), e);
        }
        log.debug("Completed response from ServiceB");
        return response;
    }

    @GetMapping("/")
    public String index(){
        return "Welcome";

    }


}
