plugins {
    kotlin("jvm") apply false
    `kotlin-dsl` apply false
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}
