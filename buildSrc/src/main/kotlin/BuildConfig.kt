object BuildConfig {
    val minecraftVersion: String = "1.21.8"
    val minecraftVersionRange: String = ">=1.21.6 <=1.21.8"
    val yarnMappings: String = minecraftVersion + "+build.1"
    val loaderVersion: String = "0.16.14"

    val modVersion: String = minecraftVersion + "-1.0.7"
    val mavenGroup: String = "io.github.macuguita"
    val modId: String = "spanishdelight"
    val modName: String = "Spanish Delight Refabricated"
    val description: String = "An addon for Farmer's Delight Refabricated that adds regional plates from Spain!"
    val license: String = "MIT"

    val fabricVersion: String = "0.129.0+" + minecraftVersion
    val modMenuVersion: String = "15.0.0-beta.3"
    val fdrfVersion: String = minecraftVersion + "-3.2.4+refabricated"
}
