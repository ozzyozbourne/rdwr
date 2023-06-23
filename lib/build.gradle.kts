import java.net.URI

plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.freefair.lombok") version "8.0.1"
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-toml:2.15.2")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:2.15.2")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.15.2")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    api("com.jayway.jsonpath:json-path:2.8.0")
    api("org.yaml:snakeyaml:2.0")

    testImplementation("org.testng:testng:7.8.0")
    testImplementation("net.datafaker:datafaker:1.9.0")
    testImplementation("ch.qos.logback:logback-classic:1.4.5")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

reporting.baseDir = file("gradleOutput")


tasks.named<Test>("test") {
    useTestNG{
        isUseDefaultListeners = true
        suites("src/test/resources/testNGxmls/${providers.gradleProperty("xmlFileName").get()}.xml")
        outputDirectory = file("$projectDir/testngOutput")
    }
    testLogging {
        events("PASSED", "SKIPPED", "FAILED", "STANDARD_OUT", "STANDARD_ERROR")
    }
}

publishing {
    publications{
        create<MavenPublication>("mavenJava"){
            groupId = "io.github.ozzyozbourne"
            artifactId = "rdwr"
            version = "0.4.0"

            from(components["java"])

            pom {

                name.set("rdwr")
                description.set("Toml, Yaml, CSV, Json, Xml and Property format readers and writers")
                url.set("https://github.com/ozzyozbourne/rdwr")
                inceptionYear.set("2023")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://www.opensource.org/licenses/mit-license.php")
                    }
                }

                developers {
                    developer {
                        id.set("khanosaid")
                        name.set("osaid khan")
                        email.set("khanosaid726@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git:github.com/ozzyozbourne/rdwr.git")
                    developerConnection.set("scm:git:ssh://github.com/ozzyozbourne/rdwr.git")
                    url.set("https://github.com/ozzyozbourne/rdwr")
                }
            }
        }
    }

    repositories {
        maven {
            name = "OSSRH"
            url =  URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = providers.gradleProperty("storedUsername").get()
                password = providers.gradleProperty("storedPassword").get()
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<JavaCompile> {
    options.release.set(17)
}

