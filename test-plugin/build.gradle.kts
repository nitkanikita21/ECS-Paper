plugins {
    kotlin("jvm") version "1.8.10"
    id("io.papermc.paperweight.userdev") version "1.5.5"
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
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

// Configure plugin.yml generation
bukkit {
    load = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.PluginLoadOrder.STARTUP
    main = "com.example.TestPlugin"
    apiVersion = "1.20"
    authors = listOf("Example")
    name = "TestPlugin"
}