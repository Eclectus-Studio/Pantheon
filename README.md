![Logo Banner](assets/banner.png)

Pantheon, a custom item framework for PaperMC.

## Features

* Write entire Resource Packs from Java, no manual JSON writing needed.
* The framework manages events such has rightClick, leftClick, onDrop,etc.
* Auto-builds the Resource Pack and can even host it.

---

## Installation

To install the Pantheon API to your server, you must do the following:

1. Compile Pantheon from source to get your plugin jar
2. Upload the jar to your server plugins/ folder
3. Restart the server, this plugin uses the Bootstrap phase and the new Paper command api, bukkit:reload will cause the plugin to crash.

---

## Developer Guide

### Dependency Configuration

To add Pantheon to one of your plugins add it to your Gradle project.

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
    compileOnly("com.github.Eclectus-Studio.Pantheon:paper:Alpha-0.3.1")
}
```
