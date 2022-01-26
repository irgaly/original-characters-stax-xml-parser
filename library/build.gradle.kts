plugins {
    kotlin("jvm")
    id("maven-publish")
}

sourceSets.configureEach {
    java.srcDirs("src/$name/kotlin")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation("com.fasterxml.woodstox:woodstox-core:6.2.8")
    testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
    testImplementation("io.kotest:kotest-assertions-core:5.1.0")
}

group = "io.github.irgaly.xml"
version = "1.0.0"

java {
    withSourcesJar()
    withJavadocJar()
}
