# MembersApp 

This is sample membersapp project.

## Prerequisites for building
+ jdk 1.8
+ gradle (can be installed via sdkman)
+ npm (installed with nodejs)
+ angular-cli (npm install -g angular-cli) 

## Build frontend
``` cd frontend && ng build```

## Build application
```cd ../ && gradle clean build```

## Run as fat-jar application
```java -jar build/libs/membersapp-0.0.2.jar```