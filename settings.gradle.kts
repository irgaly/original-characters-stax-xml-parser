enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "1.6.10"
    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
rootProject.name = "original-characters-stax-xml-parser"
include(":library")
