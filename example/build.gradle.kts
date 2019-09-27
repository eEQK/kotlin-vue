plugins {
    kotlin("js")
}

group = "kotlin-wrapper"
version = "1.0-SNAPSHOT"

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
            runTask {
                sourceMaps = true
                saveEvaluatedConfigFile = true
                devServer = devServer!!.copy(
                    open = false,
                    port = 8083
                )
            }
        }
        sourceSets {
            main {
                dependencies {
                    implementation(project(":modules:core"))
                    implementation(project(":modules:css"))

                    implementation(npm("vue", "latest"))
                    implementation(npm("core-js", "latest"))
                    implementation(npm("vue-router", "latest"))
                    implementation(npm("@vue/composition-api", "latest"))
                    implementation(npm("@fortawesome/vue-fontawesome", "latest"))
                    implementation(npm("@fortawesome/fontawesome-svg-core", "latest"))
                    implementation(npm("@fortawesome/free-solid-svg-icons", "latest"))

                    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${Kotlin.version}")

                    implementation("org.jetbrains:kotlin-css-js:${Kotlin.extensions}")
                    implementation("org.jetbrains:kotlin-extensions:${Kotlin.extensions}")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${Kotlin.coroutines}")
                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:${Kotlin.serialization}")
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

