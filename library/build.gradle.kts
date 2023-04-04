import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

sourceSets.configureEach {
    java.srcDirs("src/$name/kotlin")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    api("com.fasterxml.woodstox:woodstox-core:6.5.0")
    testImplementation("io.kotest:kotest-runner-junit5:5.2.2")
    testImplementation("io.kotest:kotest-assertions-core:5.2.2")
}

java {
    withSourcesJar()
    withJavadocJar()
}

val dokkaJavadoc by tasks.getting(DokkaTask::class)
val javadocJar by tasks.getting(Jar::class) {
    dependsOn(dokkaJavadoc)
    from(dokkaJavadoc.outputDirectory)
}

signing {
    useInMemoryPgpKeys(System.getenv("SIGNING_PGP_KEY"), System.getenv("SIGNING_PGP_PASSWORD"))
    sign(publishing.publications)
}

group = "io.github.irgaly.xml"
version = "1.0.1"

publishing {
    publications {
        create<MavenPublication>("mavenCentral") {
            from(components["java"])
            artifactId = "original-characters-stax"
            pom {
                name.set(artifactId)
                description.set("A Stax Parser Wrapper with original texts from input XML.")
                url.set("https://github.com/irgaly/original-characters-stax-xml-parser")
                developers {
                    developer {
                        id.set("irgaly")
                        name.set("irgaly")
                        email.set("irgaly@gmail.com")
                    }
                }
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                scm {
                    connection.set("git@github.com:irgaly/original-characters-stax-xml-parser.git")
                    developerConnection.set("git@github.com:irgaly/original-characters-stax-xml-parser.git")
                    url.set("https://github.com/irgaly/original-characters-stax-xml-parser")
                }
            }
        }
    }
}
