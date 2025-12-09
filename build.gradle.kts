plugins {
    id("net.fabricmc.fabric-loom-remap").version("1.14-SNAPSHOT")
    id("maven-publish")
    id("me.modmuss50.mod-publish-plugin").version("1.0.0")
}

loom {
    runs {
        register("datagen") {
            client()
            name = "Data Generation"

            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.modid=${BuildConfig.modId}")
            vmArg("-Dfabric-api.datagen.output-dir=${project.file("src/main/generated")}")
            runDir("build/datagen")

            ideConfigGenerated(true)
        }
        configureEach {
            if (name == "server") {
                vmArg("-Dfabric-tag-conventions-v2.missingTagTranslationWarning=VERBOSE")
            }
        }
    }
}

sourceSets {
    main {
        resources.srcDir("src/main/generated")
        resources.exclude(".cache")
    }
}

version = BuildConfig.modVersion
group = BuildConfig.mavenGroup

base {
    archivesName.set(BuildConfig.modId)
}

repositories {
    maven {
        name = "Greenhouse Maven"
        url = uri("https://maven.greenhouse.lgbt/releases/")
    }
    maven {
        name = "Greenhouse Maven"
        url = uri("https://maven.greenhouse.lgbt/snapshots/") // Porting Lib Hotfixes
    }
    maven {
        name = "Porting Lib Betas"
        url = uri("https://mvn.devos.one/snapshots/")
    }
    maven {
        name = "Fabric ASM"
        url = uri("https://jitpack.io/")
        content {
            excludeGroup("io.github.fabricators_of_create")
        }
    }
    maven {
        name = "Shedaniel maven"
        url = uri("https://maven.shedaniel.me/")
    }
    maven {
        name = "TerraformersMC"
        url = uri("https://maven.terraformersmc.com/")
    }
    flatDir { dirs("libs") }
}

dependencies {
    minecraft("com.mojang:minecraft:${BuildConfig.minecraftVersion}")
    mappings(loom.layered {
        officialMojangMappings()
        BuildConfig.parchmentMappings?.let { parchment("org.parchmentmc.data:parchment-${BuildConfig.minecraftVersion}:$it@zip") }
    })
    modImplementation("net.fabricmc:fabric-loader:${BuildConfig.loaderVersion}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${BuildConfig.fabricVersion}")

//    modImplementation("com.terraformersmc:modmenu:${BuildConfig.modMenuVersion}") {
//        exclude(group = "net.fabricmc")
//    }

    modImplementation("vectorwing:FarmersDelight:${BuildConfig.fdrfVersion}") {
        exclude(group = "net.fabricmc")
    }
}

val changelogText: String = File("CHANGELOG.md").readText()

publishMods {
    changelog = changelogText
    file.set(tasks.remapJar.get().archiveFile)
    additionalFiles.from(tasks.remapSourcesJar.get().archiveFile)
    displayName = BuildConfig.modName + " " + BuildConfig.modVersion
    version = BuildConfig.modVersion
    if (BuildConfig.modVersion.contains("beta")) {
        type = BETA
    } else {
        type = STABLE
    }
    modLoaders.add("fabric")
    modLoaders.add("quilt")
    dryRun = providers.environmentVariable("MODRINTH_TOKEN").getOrNull() == null
    modrinth {
        projectId = "E2LV3K2B"
        accessToken = providers.environmentVariable("MODRINTH_TOKEN")
        for (version in BuildConfig.supportedVersions)
            minecraftVersions.add(version)
        requires("fabric-api")
        requires("farmers-delight-refabricated")
    }
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(
            "version"  to BuildConfig.modVersion,
            "modId"                 to BuildConfig.modId,
            "modName"               to BuildConfig.modName,
            "description"           to BuildConfig.description,
            "license"               to BuildConfig.license,
            "loaderVersion"         to BuildConfig.loaderVersion,
            "minecraftVersion"      to BuildConfig.minecraftVersion,
            "minecraftVersionRange" to BuildConfig.minecraftVersionRange
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${BuildConfig.modId}"}
    }
}

// configure the maven publication
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = BuildConfig.modId
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}
