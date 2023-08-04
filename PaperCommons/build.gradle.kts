plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.5.5"
}

group = "com.nitkanikita"

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

