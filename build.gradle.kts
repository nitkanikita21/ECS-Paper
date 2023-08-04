plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.5.5"
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

allprojects {
    group = rootProject.findProperty("project.group")!!
    version = rootProject.findProperty("project.version")!!
}

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.11.3")

    implementation(project(":Core"))
    implementation(project(":PaperCommons"))
    implementation(project(":Items"))
}

tasks.shadowJar {
    dependencies {
        include(dependency(":Core"))
        include(dependency(":PaperCommons"))
        include(dependency(":Items"))
        include(dependency("org.jetbrains:annotations:24.0.0"))
    }
}

tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.20.1")
    }
}