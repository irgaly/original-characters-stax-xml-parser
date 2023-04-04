import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    api(libs.fasterxml.woodstox)
    testImplementation(libs.test.kotest.runner)
    testImplementation(libs.test.kotest.assertions)
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
    useInMemoryPgpKeys(
        providers.environmentVariable("SIGNING_PGP_KEY").orNull,
        providers.environmentVariable("SIGNING_PGP_PASSWORD").orNull
    )
    if (providers.environmentVariable("CI").isPresent) {
        sign(extensions.getByType<PublishingExtension>().publications)
    }
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
