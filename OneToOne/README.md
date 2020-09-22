

### One-To-One Example


To run this example:
+ Generate Gradle wrapper (in parent directory)
+ Execute with command (parent directory)

```
./gradlew OneToOne:bootRun
```

#### Highlights

+ To access H2 Console: http://localhost:8080/h2-console/ (after Spring Boot initialization)
+ application.properties in project
+ Switching Database: H2-memory Database / h2-file database (application.properties)
+ JAX-B dependencies for JDK 9+ (JAXB not exists in JDK 9+, see build.gradle)