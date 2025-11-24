object BuildConfig {
    val minecraftVersion: String = "1.21.10"
    val minecraftVersionRange: String = ">=1.21.9 <=1.21.10"
    val supportedVersions: Array<String> = arrayOf("1.21.9", "1.21.10")
    val yarnMappings: String = minecraftVersion + "+build.1"
    val loaderVersion: String = "0.17.2"

    val modVersion: String = minecraftVersion + "-1.0.7"
    val mavenGroup: String = "io.github.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.135.0+" + minecraftVersion
    val modMenuVersion: String = "16.0.0-rc.1"
    val fdrfVersion: String = minecraftVersion + "-3.3.1+refabricated"
}
