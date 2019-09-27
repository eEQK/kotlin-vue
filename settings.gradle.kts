rootProject.name = "kotlin-vue"

include("example")

include(
    ":modules:buildSrc",
    ":modules:cssdsl",
    ":modules:core"
)
