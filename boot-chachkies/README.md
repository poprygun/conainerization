# Spring Boot Containerization options

## Using Spring Boot Gradle Plugin

Latest versions of the Spring Boot have for out of the box support for creating OCI images.

List Gradle tasks and make sure that bootBuildImage is listed

```bash
./gradlew tasks

Build tasks
-----------
...
bootBuildImage - Builds an OCI image of the application using the output of the bootJar task
...
```

Run bootBuildImage task and verify that image was created

```bash
./gradlew bootBuildImage

docker images | grep chachkies
boot-chachkies     0.0.1-SNAPSHOT   d10927a72431   42 years ago    275MB
```

Run the application container

```bash
docker run -p 8080:8080 d10927a72431
```

