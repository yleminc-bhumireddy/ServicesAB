package com.mycomp.cotroller;

import com.mycomp.com.mycomp.model.PingResponse;
import com.mycomp.com.mycomp.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.*;

@RestController
@Slf4j
public class ServiceA {

    private RestTemplate restTemplate = new RestTemplate();

    private final String baseUrl = "http://localhost:8080" +  "/pingB";


    @GetMapping("/ping")
    public ResponseEntity<PingResponse> ping() throws IOException, URISyntaxException {
        log.debug("Invoked ping()");
        PingResponse.PingResponseBuilder responseBuilder = PingResponse.builder()
                    .hostName(InetAddress.getLocalHost().getHostName())
                    .ipAddress(Util.getLocalIPAddress()).response(this.getClass().getCanonicalName());
//        URI uri = new URI(baseUrl);
//        ResponseEntity<PingResponse> responseB = restTemplate.getForEntity(uri, PingResponse.class);
//        if(responseB.getStatusCode().is2xxSuccessful()){
//            responseBuilder.nextResponse(responseB.getBody());
//        }
        log.debug("Completed ping()");
        return ResponseEntity.ok(responseBuilder.build());
    }


}
