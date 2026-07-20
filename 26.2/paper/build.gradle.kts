plugins {
    id("java-library")
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.21"
    id("com.gradleup.shadow") version "9.4.3"
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("26.2.build.+")
    implementation(project(":common"))
    implementation("commons-codec:commons-codec:1.22.0")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks.jar {
    archiveBaseName.set("pantheon-paper")
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    processResources {
        val props = mapOf("version" to version , "description" to project.description )
        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}
