FROM gradle:8.7.0-jdk17-alpine AS cache

WORKDIR /workspace
COPY gradle /workspace/gradle
COPY gradlew /workspace/gradlew
COPY build.gradle /workspace/build.gradle
COPY settings.gradle /workspace/settings.gradle
RUN gradle build -i --stacktrace || return 0

FROM gradle:8.7.0-jdk17-alpine AS builder

WORKDIR /workspace
COPY --from=cache /workspace /workspace
COPY . .
RUN gradle -i apps:core-service:build

FROM openjdk:17-alpine
WORKDIR /app
RUN echo "Copying jar"
COPY --from=builder /workspace/apps/core-service/build/libs/core-service.jar .
COPY --from=builder /workspace/esign-dattb-firebase-adminsdk-zxyyn-e9464763f0.json /home/dattb/service-account.json
RUN echo "Copying jar done"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","core-service.jar"]