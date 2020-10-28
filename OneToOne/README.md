
### One-To-One Example


To run this example:
+ Generate Gradle wrapper (parent directory)
+ Execute with command (from parent directory):

```
./gradlew OneToOne:bootRun
```

+ Endpoints available:
    - GET http://[IP]:8081/test
    - GET http://[IP]:8081/students/all
    
#### Highlights

+ To access H2 Console: http://localhost:8080/h2-console/ (after Spring Boot initialization)
    + <b>Warning</b>: URL of database has been changed; default url is not used
+ application.properties in project with DB user/password
+ Switching Database: H2-memory Database / h2-file database (application.properties)
+ JAX-B dependencies for JDK 9+ (JAXB not exists in JDK 9+, see build.gradle)
+ Spring Boot execute on initialization resources/schema.sql and resources/data.sql, in that order
+ Annotations @OneToOne and @JoinColumn at entities Student and Tuition
 