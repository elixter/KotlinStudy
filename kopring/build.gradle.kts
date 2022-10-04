import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.elixter"

configurations {
	all {
//		exclude("org.springframework.boot", "spring-boot-starter-logging")
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

//	implementation("org.springframework.boot:spring-boot-starter-jdbc")
//	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// Bcrypt
	implementation("de.svenkubiak:jBCrypt:0.4.3")

	// log4j2
//	implementation("org.springframework.boot:spring-boot-starter-log4j2")

	// 캐싱
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("com.github.ben-manes.caffeine:caffeine")

	implementation(project(":persistence"))
}