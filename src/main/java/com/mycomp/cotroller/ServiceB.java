package com.mycomp.cotroller;


//import lombok.extern.slf4j.Slf4j;
import com.mycomp.model.PingResponse;
import com.mycomp.util.Util;
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
        PingResponse response = new PingResponse();
        response.setHostName(InetAddress.getLocalHost().getHostName());
                    response.setIpAddress(Util.getLocalIPAddress());
                    response.setResponse(this.getClass().getCanonicalName());
//        log.debug("Completed ping()");
        return ResponseEntity.ok(response);
    }


}
