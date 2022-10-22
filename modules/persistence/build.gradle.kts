import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "com.elixter.persistence"

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = false
jar.enabled = true

repositories {
    mavenCentral()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-r2dbc")
    api("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    api("io.projectreactor.kotlin:reactor-kotlin-extensions")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}
