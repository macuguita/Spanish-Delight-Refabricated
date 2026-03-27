object BuildConfig {
    val minecraftVersion: String = "26.1"
    val minecraftVersionRange: String = ">=26.1"
    val supportedVersions: Array<String> = arrayOf("26.1")
    val parchmentMappings: String? = null
    val loaderVersion: String = "0.18.4"

    val modVersion: String = minecraftVersion + "-1.0.9"
    val mavenGroup: String = "com.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.144.3+" + minecraftVersion
//    val modMenuVersion: String = "16.0.0-rc.1"
    val fdrfVersion: String = minecraftVersion + "-3.5.0+refabricated"
}
