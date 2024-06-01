## Getting started with SmartyStreets API

-   API docs - https://www.smarty.com/docs/sdk/java
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
-   Run it! You can see the address suggestions logged in the terminal.
