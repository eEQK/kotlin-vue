plugins {
    kotlin("js") version Kotlin.version apply false
}

allprojects {
    group = "kotlin-wrapper"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
        maven(url = "https://dl.bintray.com/kotlinx/kotlinx")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-js-wrappers")
    }
}