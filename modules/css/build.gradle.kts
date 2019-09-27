plugins {
    kotlin("js")
}

kotlin {
    target {
        browser {
            val main by compilations.getting {
                kotlinOptions {
                    sourceMap = true
                    moduleKind = "commonjs"
                    sourceMapEmbedSources = "always"
                }
            }
        }
        sourceSets {
            main {
                dependencies {
                    implementation(npm("@jetbrains/kotlin-css", "latest"))
                    implementation(npm("@jetbrains/kotlin-css-js", "latest"))
                    implementation(npm("@jetbrains/kotlin-extensions", "latest"))

                    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${Kotlin.version}")

                    implementation("org.jetbrains:kotlin-css-js:${Kotlin.extensions}")
                    implementation("org.jetbrains:kotlin-extensions:${Kotlin.extensions}")
                }
            }
            test {
                dependencies {
                    implementation(kotlin("test-js"))
                }
            }
        }
    }
}