plugins {
    id("java")
}

group = "com.nitkanikita"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jetbrains:annotations:24.0.0")

    compileOnly("org.slf4j:slf4j-api:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}