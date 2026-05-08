plugins {
    id("net.fabricmc.fabric-loom").version("1.16-SNAPSHOT")
    id("maven-publish")
    id("me.modmuss50.mod-publish-plugin").version("1.0.0")
    id("co.uzzu.dotenv.gradle") version "4.0.0"
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
    flatDir { dirs("libs") }
//    maven {
//        name = "Greenhouse Maven"
//        url = uri("https://maven.greenhouse.lgbt/releases/")
//    }
//    maven {
//        name = "Greenhouse Maven"
//        url = uri("https://maven.greenhouse.lgbt/snapshots/") // Porting Lib Hotfixes
//    }
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
    maven {
        name = "Cassian's Maven"
        url = uri("https://maven.cassian.cc/")
        content {
            includeGroupAndSubgroups("cc.cassian")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${BuildConfig.minecraftVersion}")
    implementation("net.fabricmc:fabric-loader:${BuildConfig.loaderVersion}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    implementation("net.fabricmc.fabric-api:fabric-api:${BuildConfig.fabricVersion}")

//    implementation("com.terraformersmc:modmenu:${BuildConfig.modMenuVersion}") {
//        exclude(group = "net.fabricmc")
//    }

    implementation("vectorwing:FarmersDelight:${BuildConfig.fdrfVersion}") {
        exclude(group = "net.fabricmc")
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
            "minecraftVersionRange" to BuildConfig.minecraftVersionRange,
            "fdrfVersion" to BuildConfig.fdrfVersion
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${BuildConfig.modId}"}
    }
}

val changelogText: String = File("CHANGELOG.md").readText()

publishMods {
    changelog = changelogText
    file = tasks.jar.map { it.archiveFile.get() }
    additionalFiles.from(tasks.named<org.gradle.jvm.tasks.Jar>("sourcesJar").map { it.archiveFile.get() })
    displayName = BuildConfig.modName + " " + BuildConfig.modVersion
    version = BuildConfig.modVersion
    if (BuildConfig.modVersion.contains("beta")) {
        type = BETA
    } else {
        type = STABLE
    }
    modLoaders.add("fabric")
    modLoaders.add("quilt")
    modrinth {
        projectId = "E2LV3K2B"
        accessToken = env.MODRINTH_API_KEY.orNull()
        for (version in BuildConfig.supportedVersions)
            minecraftVersions.add(version)
        requires("fabric-api")
        requires("farmers-delight-refabricated")
    }
}

// configure the maven publication
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = BuildConfig.mavenGroup
            artifactId = BuildConfig.modId
            version = BuildConfig.modVersion + "+${BuildConfig.minecraftVersion}"
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
        maven {
            name = "macuguita"
            url = uri("https://maven.macuguita.com/releases")

            credentials {
                username = env.MAVEN_USERNAME.orNull()
                password = env.MAVEN_KEY.orNull()
            }
        }
    }
}
