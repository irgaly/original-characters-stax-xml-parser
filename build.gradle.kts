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
            // io.github.irgaly staging profile
            stagingProfileId = "6c098027ed608f"
            nexusUrl = uri("https://s01.oss.sonatype.org/service/local/")
            snapshotRepositoryUrl =
                uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}
