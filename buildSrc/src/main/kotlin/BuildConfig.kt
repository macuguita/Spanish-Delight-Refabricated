object BuildConfig {
    val minecraftVersion: String = "26.2"
    val minecraftVersionRange: String = ">=26.2-"
    val supportedVersions: Array<String> = arrayOf("26.2")
    val parchmentMappings: String? = null
    val loaderVersion: String = "0.19.3"

    val modVersion: String = minecraftVersion + "-1.0.11"
    val mavenGroup: String = "com.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.154.2+" + minecraftVersion
//    val modMenuVersion: String = "16.0.0-rc.1"
    val fdrfVersion: String = "26.2-3.6.7+refabricated"
}
