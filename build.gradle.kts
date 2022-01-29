plugins {
    kotlin("jvm") apply false
    `kotlin-dsl` apply false
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

nexusPublishing {
    repositories {
        sonatype {
            // io.github.irgaly staging profile
            stagingProfileId.set("6c098027ed608f")
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
