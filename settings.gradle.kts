plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "rdwr"
include("lib")

buildCache {
    local {
        directory = File(rootDir, "build-cache")
        removeUnusedEntriesAfterDays = 30
    }
}


