object BuildConfig {
    val minecraftVersion: String = "1.21.1"
    val minecraftVersionRange: String = "1.21.1"
    val supportedVersions: Array<String> = arrayOf("1.21.1")
    val yarnMappings: String = minecraftVersion + "+build.3"
    val loaderVersion: String = "0.16.14"

    val modVersion: String = minecraftVersion + "-1.0.8a"
    val mavenGroup: String = "io.github.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.116.1+" + minecraftVersion
    val modMenuVersion: String = "11.0.3"
    val fdrfVersion: String = minecraftVersion + "-3.1.0+refabricated"
    val emiVersion: String = "1.1.22+" + minecraftVersion
}