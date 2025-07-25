import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.nexus.publish)
}

subprojects {
    afterEvaluate {
        pluginManager.withPlugin(libs.plugins.kotlin.jvm.get().pluginId) {
            extensions.configure<KotlinProjectExtension> {
                jvmToolchain(11)
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            stagingProfileId = libs.versions.library.version.get()
            nexusUrl = uri("https://ossrh-staging-api.central.sonatype.com/service/local/")
            snapshotRepositoryUrl =
                uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }
}
