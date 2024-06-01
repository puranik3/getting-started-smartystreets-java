## Getting started with SmartyStreets API

-   API docs - https://www.smarty.com/docs/sdk/java
-   Download .jar file - https://mvnrepository.com/artifact/com.smartystreets.api/smartystreets-java-sdk/3.17.0. Place the jat file in a new folder.
-   Follow the example in the API docs to create `Example.java`. Place this .java file in the same folder.

```java
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.*;

import java.io.IOException;

public class Example {
    private static String SMARTY_AUTH_ID = "<your_auth_id>";
    private static String SMARTY_AUTH_TOKEN = "<your_auth_token>";

    public static void main(String[] args) throws IOException, SmartyException {
        // This keypair will have been deleted by the time you are watching this video...
        String authId = Example.SMARTY_AUTH_ID;
        String authToken = Example.SMARTY_AUTH_TOKEN;

        System.out.println("Step 0. Wire up the client with your keypair.");
        Client client = new ClientBuilder(authId, authToken).buildUsStreetApiClient();

        System.out.println("Step 1. Make a lookup. (BTW, you can also send entire batches of lookups...)");
        Lookup lookup = new Lookup();
        lookup.setStreet("1 Rosedale");
        lookup.setLastline("Baltimore MD");
        lookup.setMaxCandidates(10);

        try {
            System.out.println("Step 2. Send the lookup.");
            client.send(lookup);

            System.out.println("Step 3. Show the resulting candidate addresses:");
            int index = 0;
            for (Candidate candidate : lookup.getResult()) {
                System.out.printf("- %d: %s, %s\n", index, candidate.getDeliveryLine1(), candidate.getLastLine());
                        index++;
            }
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
```

-   Compile and run it

```
java -cp .:smartystreets-java-sdk-2.1.2.jar Example
```
