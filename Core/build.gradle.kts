plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    compileOnly("org.slf4j:slf4j-api:2.0.7")
}