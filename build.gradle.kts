import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.lucksonmwanambulo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

dependencies{
    implementation("org.seleniumhq.selenium:selenium-java:4.1.2")
}

application {
    mainClass.set("MainKt")
}