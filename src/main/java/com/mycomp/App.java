package com.mycomp;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Slf4j
public class App {

    public static void main(String[] args) {
        try {
            SpringApplication.run(App.class);
        }catch(Exception e){
            e.printStackTrace();
//            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
//spring.cloud.azure.active-directory.enabled=true
//        spring.cloud.azure.active-directory.profile.tenant-id=b705d325-1562-4111-a055-b0b7dd21c002
//        spring.cloud.azure.active-directory.credential.client-id=957543e2-580e-40e2-81f3-39f5c95a8f28
//        spring.cloud.azure.active-directory.credential.client-secret=azb8Q~RA9X2OhKlEHT6Er2mcOgVs.keWXQ6Txatu
//        spring.cloud.azure.active-directory.authorization-clients.graph.scopes=https://graph.microsoft.com/User.Read
//        #spring.cloud.azure.active-directory.user-group.allowed-group-ids=Users
//
