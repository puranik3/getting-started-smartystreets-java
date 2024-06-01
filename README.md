## Using SmartyStreets API

-   Go to the organization page on GitHub

    -   https://github.com/smartystreets

-   Check the Java API repo

    -   https://github.com/orgs/smartystreets/repositories
    -   https://github.com/smartystreets/smartystreets-java-sdk

-   Check the README -> documentation and examples

    -   https://www.smarty.com/docs/sdk/java
    -   https://github.com/smartystreets/smartystreets-java-sdk/tree/master/src/main/java/examples

-   Check the JavaScript SDK

    -   https://www.smarty.com/docs/sdk/javascript

-   Follow the example given in the repo

```
git clone https://github.com/smartystreets/smartystreets-java-sdk
```

## Obtaining an API Key

-   https://www.smarty.com/pricing/us-address-autocomplete -> Choose Free account and follow the steps
-   Then click on the left sidebar -> API keys (create a Server key)

## Recreating the example

-   Create a starter application using https://start.spring.io/.
    -   Choose
        -   Project: `Maven`
        -   Group: `com.digdeeper.GettingStartedSmartyStreetsJava`
        -   Package Name: `com.digdeeper.GettingStartedSmartyStreetsJava`
    -   Hit Generate
        -   The starter app downloads. Unzip it.
-   Open the starter app in your editor.
-   Add SmartStreets dependency in `pom.xml` inside `dependencies`

```xml
<!-- https://mvnrepository.com/artifact/com.smartystreets.api/smartystreets-java-sdk -->
<dependency>
    <groupId>com.smartystreets.api</groupId>
    <artifactId>smartystreets-java-sdk</artifactId>
    <version>3.17.0</version>
</dependency>
```

-   Make sure that Maven loads the changes, i.e. downloads the SmartStreets Jar file. For example, in IntelliJ, you get a button on the right to "Load Maven Changes" and clicking it does the job.

-   Create the 2 files in `com.digdeeper.GettingStartedSmartyStreetsJava.demo` package with contents as in this repository's demo folder.
-   Fill in your `SMARTY_AUTH_ID` and `SMARTY_AUTH_TOKEN` in `SmartStreetsService.java`

```java
private static String SMARTY_AUTH_ID = "<your_auth_id>";
private static String SMARTY_AUTH_TOKEN = "<your_auth_token>";
```

-   Run it! You can see the address suggestions logged in the terminal.
