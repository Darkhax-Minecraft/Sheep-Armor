<!-- name-start -->
# SheepArmor [![CurseForge Project](https://img.shields.io/curseforge/dt/951457?logo=curseforge&label=CurseForge&style=flat-square&labelColor=2D2D2D&color=555555)](https://curseforge.com/minecraft/mc-mods/sheep-armor) [![Modrinth Project](https://img.shields.io/modrinth/dt/3FMUP6BE?logo=modrinth&label=Modrinth&style=flat-square&labelColor=2D2D2D&color=555555)](https://modrinth.com/mod/sheep-armor/version/XepF4jaZ) [![Maven Project](https://img.shields.io/maven-metadata/v?style=flat-square&logoColor=D31A38&labelColor=2D2D2D&color=555555&label=Latest&logo=gradle&metadataUrl=https%3A%2F%2Fmaven.blamejared.com%2Fnet%2Fdarkhax%2Fsheeparmor%2Fsheeparmor-common-1.21.1%2Fmaven-metadata.xml)](https://maven.blamejared.com/net/darkhax/sheeparmor)
<!-- name-end -->
<!-- description-start -->
Grants sheep a small armor bonus while they still have wool. The documentation for this mod can be found [here](https://docs.darkhax.net/mods/sheeparmor).
<!-- description-end -->

<!-- maven-start -->
## Maven Dependency

If you are using [Gradle](https://gradle.org) to manage your dependencies, add the following into your `build.gradle` file. Make sure to replace the version with the correct one. All versions can be viewed [here](https://maven.blamejared.com/net/darkhax/sheeparmor).

```gradle
repositories {
    maven { 
        url 'https://maven.blamejared.com'
    }
}

dependencies {
    // NeoForge
    implementation group: 'net.darkhax.sheeparmor', name: 'sheeparmor-neoforge-1.21.1', version: '21.1.0'

    // Forge
    implementation group: 'net.darkhax.sheeparmor', name: 'sheeparmor-forge-1.21.1', version: '21.1.0'

    // Fabric & Quilt
    modImplementation group: 'net.darkhax.sheeparmor', name: 'sheeparmor-fabric-1.21.1', version: '21.1.0'

    // Common / MultiLoader / Vanilla
    compileOnly group: 'net.darkhax.sheeparmor', name: 'sheeparmor-common-1.21.1', version: '21.1.0'
}
```
<!-- maven-end -->

<!-- sponsor-start -->
## Sponsors

[![](https://assets.blamejared.com/nodecraft/darkhax.jpg)](https://nodecraft.com/r/darkhax)    
SheepArmor is sponsored by Nodecraft. Use code **[DARKHAX](https://nodecraft.com/r/darkhax)** for 30% of your first month of service!
<!-- sponsor-end -->