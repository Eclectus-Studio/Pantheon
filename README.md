# Pantheon

A powerful, developer-first Minecraft plugin framework designed to handle custom items, blocks, data pack logic, and dynamic resource pack generation entirely through a Java API. 

## Features

* **Pure Java Definition:** Create custom items, blocks, food, tools, and mob variants entirely in Java code. No tedious manual JSON writing for data packs or resource packs.
* **Automated Resource Pack Builder:** Automatically generates textures, models, overrides, and language files on server startup.
* **Data Pack Integration:** Register custom recipes, loot tables, advancements, and dimensions via Java that hook directly into the server's data pack registry.
* **Mob Variants:** Dynamically add custom entity textures and models (utilizing core shaders or OptiFine/Entity Texture Features formatting) directly through the API.
* **Zero Config Deployment:** Automatically hosts the generated resource pack via an embedded HTTP server or uploads it to a self-hosted platform, prompting players to download it upon joining.

---

## Installation

1. Download the latest release `.jar` file.
2. Place the file into your server's `plugins/` directory.
3. Restart the server to generate the default configuration files.

---

## Developer Guide

### Dependency Configuration

To use the Pantheon API in your project, add the dependency to your build system.
(Docs comming soon right after the main resource pack logic is made and have a cleaner api on top)

#### Gradle
```gradle
repositories{
  maven { url = uri("https://jitpack.io") }
}

dependencies {
    compileOnly("com.github.Eclectus-Studio.Pantheon:submodule:ver:all")
}
```
Ex:
```gradle
dependencies {
    compileOnly("com.github.Eclectus-Studio.Pantheon:26.1.2:Alpha-0.0.8:all")
}
```
