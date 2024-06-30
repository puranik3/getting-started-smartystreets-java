package com.digdeeper.GettingStartedSmartyStreetsJava.demo;

import com.digdeeper.GettingStartedSmartyStreetsJava.demo.SmartStreetsService;
import com.smartystreets.api.exceptions.BadCredentialsException;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_autocomplete_pro.Suggestion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class SsUsAddressAutoProRestController {
    @RequestMapping(value = "/suggestions", method = RequestMethod.GET)
    public ResponseEntity<?> getSuggestions(
        @RequestParam("filterKey") String filterKey,
        @RequestParam(value= "cities", required = false) String citiesStr,
        @RequestParam(value="states", required = false) String statesStr
    ) {
        String[] cities = {}, states = {};
        boolean useLookupFilterAndPrefer = citiesStr != null && statesStr != null;

        if(useLookupFilterAndPrefer) {
            cities = citiesStr.split(",");
            states = statesStr.split(",");
        }

        try {
            System.out.println("filterKey = " + filterKey);

            Suggestion[] suggestions = {};

            if( useLookupFilterAndPrefer ) {
                suggestions = SmartStreetsService.lookupFilterAndPrefer(filterKey, cities, states);
            } else {
                suggestions = SmartStreetsService.lookupSimple(filterKey);
            }

            System.out.println( "*** Suggestions (response) ***" );
            SmartStreetsService.printResult(suggestions);

            return ResponseEntity.ok(suggestions);
        } catch(SmartyException | IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println( e.getMessage() );
        }

        return ResponseEntity.internalServerError().build();
    }
}