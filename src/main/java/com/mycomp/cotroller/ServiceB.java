package com.mycomp.cotroller;

import com.mycomp.com.mycomp.model.PingResponse;
import com.mycomp.com.mycomp.util.Util;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;

@RestController
//@Slf4j
public class ServiceB {

    @GetMapping("/pingB")
    public ResponseEntity<PingResponse> ping() throws IOException {
//        log.debug("Invoked ping()");
        PingResponse response = PingResponse.builder()
                    .hostName(InetAddress.getLocalHost().getHostName())
                    .ipAddress(Util.getLocalIPAddress()).response(this.getClass().getCanonicalName()).build();
//        log.debug("Completed ping()");
        return ResponseEntity.ok(response);
    }


}
