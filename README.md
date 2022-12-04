# Quarkus :zap: Native Build

## About Quarkus and this example

[Quarkus](https://quarkus.io/) is a Kubernetes Native Java stack tailored for OpenJDK HotSpot and GraalVM.

It provides a fast boot time, low RSS memory and offers near instant scale up and high density memory utilization in container orchestration platforms like Kubernetes.

In this example you can check how to build a Docker image containing your Quarkus application built as an executable native file without the need of installing GraalVM.

## Technical requirements

You are going to need only 2 things

- A Quarkus project, if you need some help at setting it up you can check how [in this example](https://github.com/codewithhades/quarkus-basic-setup)
- [Docker](https://www.docker.com), so you can build the Docker image
- A compatible [JDK](https://www.oracle.com/java/technologies/downloads) with GraalVM, this example is built on version 17

## How to build the Docker image with the executable native file

To create the Docker image with the executable native file we first need to add the following to the [pom.xml](pom.xml).

- The Quarkus container image JIB extension dependency in order to create a Docker image with the native file
    ````xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-container-image-jib</artifactId>
    </dependency>
    ````
- The native profile
    ````xml
    <profiles>
        <profile>
            <id>native</id>
            <properties>
                <quarkus.package.type>native</quarkus.package.type>
            </properties>
        </profile>
    </profiles>
    ````
  
Once we have done this we just need to simply package the project using Maven with the native profile and the container options

````bash
mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
````

We should be able to see at the end of the build logs the following message

````txt
Created container image hades/quarkus-native-build:1.0-SNAPSHOT
````


## How to run the executable native file

We just simply need to run the created Docker image with

````bash
docker run -p 8080:8080 hades/quarkus-native-build:1.0-SNAPSHOT
````

This should start your application with improved boot time and memory footprint.


## And before you go...

:pray: I hope you find this example useful and if you want to support me in my mission to help our fellow Java developers please consider starring and sponsoring this space!

:coffee: May Java be with you!

