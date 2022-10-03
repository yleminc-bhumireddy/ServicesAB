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
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
