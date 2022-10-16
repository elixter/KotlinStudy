FROM openjdk:11-jre-slim AS builder
WORKDIR /home/workspace/apps

# add source code
COPY gradlew .
COPY gradle/ ./gradle/
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY modules/ ./modules/

# build
RUN chmod +x ./gradlew
RUN ./gradlew clean kopring:bootJar -Dorg.gradle.daemon=false

# build application image
FROM openjdk:11-jre-slim
LABEL maintainer="elixter22"

COPY --from=builder kopring/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profile.active=dev"]
