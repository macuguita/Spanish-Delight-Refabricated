object BuildConfig {
    val minecraftVersion: String = "1.21.11"
    val minecraftVersionRange: String = ">=1.21.11"
    val supportedVersions: Array<String> = arrayOf("1.21.11")
    val parchmentMappings: String? = null
    val loaderVersion: String = "0.18.2"

    val modVersion: String = minecraftVersion + "-1.0.8"
    val mavenGroup: String = "io.github.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.139.4+" + minecraftVersion
//    val modMenuVersion: String = "16.0.0-rc.1"
    val fdrfVersion: String = minecraftVersion + "-3.4.1+refabricated"
}
