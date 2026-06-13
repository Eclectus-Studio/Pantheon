plugins {
    id("java-library")
    id("com.gradleup.shadow") version "9.4.2"
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.69-stable")
    shadow(project(":common"))
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks {
    shadowJar {
        configurations.set(listOf(project.configurations.shadow.get()))
        archiveClassifier.set("all")
    }

    build {
        dependsOn(shadowJar)
    }

    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("26.1.2")
        jvmArgs("-Xms2G", "-Xmx2G", "-Dcom.mojang.eula.agree=true")
    }

    processResources {
        val props = mapOf("version" to version , "description" to project.description )
        filesMatching("plugin.yml") {
            expand(props)
        }
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                // Using project.afterEvaluate delays this check until the shadow plugin finishes setting up
                project.afterEvaluate {
                    from(components["shadow"])
                }
                artifactId = project.name
            }
        }
    }
}
