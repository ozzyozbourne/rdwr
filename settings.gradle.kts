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

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("databind", "com.fasterxml.jackson.core:jackson-databind:2.15.2")
            library("dataformatxml", "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
            library("dataformatyaml", "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2")
            library("dataformattoml", "com.fasterxml.jackson.dataformat:jackson-dataformat-toml:2.15.2")
            library("dataformatproperties", "com.fasterxml.jackson.dataformat:jackson-dataformat-properties:2.15.2")
            library("dataformatcsv", "com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.15.2")
            library("dataformatjsr", "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
            library("jsonpath", "com.jayway.jsonpath:json-path:2.8.0")
            library("snakeyaml", "org.yaml:snakeyaml:2.1")
            library("testng", "org.testng:testng:7.8.0")
            library("datafaker", "net.datafaker:datafaker:1.9.0")
            library("logbackclassic", "ch.qos.logback:logback-classic:1.4.5")
            plugin("lombok", "io.freefair.lombok").version("8.3")
        }
    }
}


