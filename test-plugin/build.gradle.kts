plugins {
    kotlin("jvm") version "1.8.10"
    id("io.papermc.paperweight.userdev") version "1.5.5"
    id("xyz.jpenilla.run-paper") version "2.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(project(":Paper"))
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}

tasks.runServer {
    pluginJars.from(
        rootProject.tasks.reobfJar.get().outputJar
    )
}