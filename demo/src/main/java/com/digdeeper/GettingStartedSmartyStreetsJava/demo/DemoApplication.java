package com.digdeeper.GettingStartedSmartyStreetsJava.demo;

import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_autocomplete_pro.Suggestion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
