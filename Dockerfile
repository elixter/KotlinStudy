# build stage
FROM openjdk:11-jre-slim AS builder
ARG app
WORKDIR /home/workspace/apps

# add source code
COPY gradlew .
COPY gradle/ ./gradle/
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY modules/ ./modules/

# build
RUN chmod +x ./gradlew
RUN ./gradlew clean ${app}:bootJar -Dorg.gradle.daemon=false

# deploy stage
# build application image
FROM openjdk:11-jre-slim
LABEL maintainer="elixter22"
ARG app

WORKDIR /home/workspace/deploy/kotlin-study/${app}
COPY --from=builder /home/workspace/apps/modules/${app}/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar", "--spring.profile.active=dev"]
