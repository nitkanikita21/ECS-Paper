plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.5.5"
}

group = "com.nitkanikita"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.11.3")

    implementation(project(":Core"))
    implementation(project(":PaperCommons"))
}

tasks.test {
    useJUnitPlatform()
}