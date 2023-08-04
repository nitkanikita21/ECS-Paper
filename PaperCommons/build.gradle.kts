plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.5.5"
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}
