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
version = libs.versions.library.version.get()

publishing {
    publications {
        create<MavenPublication>("mavenCentral") {
            from(components["java"])
            artifactId = "original-characters-stax"
            pom {
                name = artifactId
                description = "A Stax Parser Wrapper with original texts from input XML."
                url = "https://github.com/irgaly/original-characters-stax-xml-parser"
                developers {
                    developer {
                        id = "irgaly"
                        name = "irgaly"
                        email = "irgaly@gmail.com"
                    }
                }
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                scm {
                    connection = "git@github.com:irgaly/original-characters-stax-xml-parser.git"
                    developerConnection =
                        "git@github.com:irgaly/original-characters-stax-xml-parser.git"
                    url = "https://github.com/irgaly/original-characters-stax-xml-parser"
                }
            }
        }
    }
}
