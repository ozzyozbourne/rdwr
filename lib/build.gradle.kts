import java.net.URI

plugins {
    `java-library`
    `maven-publish`
    signing
    alias(libs.plugins.lombok)
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.databind)
    api(libs.dataformatxml)
    api(libs.dataformatyaml)
    api(libs.dataformattoml)
    api(libs.dataformatproperties)
    api(libs.dataformatcsv)
    api(libs.dataformatjsr)
    api(libs.jsonpath)
    api(libs.snakeyaml)

    testImplementation(libs.testng)
    testImplementation(libs.datafaker)
    testImplementation(libs.logbackclassic)
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
            version = "0.4.1"

            from(components["java"])

            pom {

                name.set("rdwr")
                description.set("Toml, Yaml, CSV, Json, Xml and Property format readers and writers")
                url.set("https://github.com/ozzyozbourne/rdwr")
                inceptionYear.set("2023")

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

