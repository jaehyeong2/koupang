import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
	kotlin("kapt") version "1.8.21"
	idea
}

group = "jjfactory"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

//spring cloud. for openFeign
dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.5")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-session")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")


	//open feign
	implementation ("org.springframework.cloud:spring-cloud-starter-openfeign")

	runtimeOnly("org.postgresql:postgresql:42.6.0")

	// queryDSL
	implementation ("com.querydsl:querydsl-jpa:5.0.0:jakarta")
	kapt ("com.querydsl:querydsl-apt:5.0.0:jakarta")
	kapt ("jakarta.annotation:jakarta.annotation-api")
	kapt ("jakarta.persistence:jakarta.persistence-api")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
	testImplementation("io.kotest:kotest-assertions-core:5.5.5")
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

val querydslDir =  "build/generated/source/kapt/main"

idea {
	module {
		val kaptMain = file(querydslDir)
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}

tasks.named("clean") {
	doLast {
		file(querydslDir).deleteRecursively()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
