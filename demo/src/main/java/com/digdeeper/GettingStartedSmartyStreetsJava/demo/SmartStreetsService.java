package com.digdeeper.GettingStartedSmartyStreetsJava.demo;


import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_autocomplete_pro.Client;
import com.smartystreets.api.us_autocomplete_pro.Lookup;
import com.smartystreets.api.us_autocomplete_pro.Suggestion;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class SmartStreetsService {
    private static String SMARTY_AUTH_ID = "<your_auth_id>";
    private static String SMARTY_AUTH_TOKEN = "<your_auth_token>";

    public static Client init() {
        StaticCredentials credentials = new StaticCredentials(SmartStreetsService.SMARTY_AUTH_ID, SmartStreetsService.SMARTY_AUTH_TOKEN);

        ArrayList<String> licenses = new ArrayList<>();
        licenses.add("us-autocomplete-pro-cloud");

        Client client = new ClientBuilder(credentials).withLicenses(licenses).buildUsAutocompleteProApiClient();

        return client;
    }

    public static Suggestion[] lookupSimple( String input ) throws SmartyException, IOException, InterruptedException {
        Lookup lookup = new Lookup(input);
        lookup.setMaxResults(10);

        Client client = SmartStreetsService.init();
        client.send(lookup);
        return lookup.getResult();
    }

    public static Suggestion[] lookupFilterAndPrefer( String input, String[] cities, String[] states ) throws SmartyException, IOException, InterruptedException {
        Lookup lookup = new Lookup(input);
        lookup.setMaxResults(10);

        for( String city : cities ) {
            lookup.addCityFilter(city);
        }

        for( String state : states ) {
            lookup.addStateFilter(state);
        }

        lookup.setPreferRatio(33);
        lookup.setSource("all");

        Client client = SmartStreetsService.init();
        client.send(lookup);
        return lookup.getResult();
    }

    public static void printResult(Suggestion[] suggestions) {
        for (Suggestion suggestion : suggestions) {
            System.out.print(suggestion.getStreetLine());
            System.out.print(" ");
            System.out.print(suggestion.getSecondary());
            System.out.print(" ");
            System.out.print(suggestion.getCity());
            System.out.print(", ");
            System.out.print(suggestion.getState());
            System.out.print(", ");
            System.out.println(suggestion.getZipcode());
        }
    }
}