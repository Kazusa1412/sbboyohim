plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":bbs-api"))
    implementation("org.yaml:snakeyaml:${Versions.snakeyaml}")
}

tasks.register<Jar>("elyJar") {
    group = "elouyi"
    // archive 信息
    // archiveClassifier.set(Versions.xxx)

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
    exclude(
        "META-INF/*.SF",
        "META-INF/*.DSA",
        //"META-INF/*.RSA",
        //"META-INF/*.kotlin_module",
        "META-INF/*.md"
        //"**/*.kotlin_metadata",
        //"**/*.kotlin_builtins",
        //"**/*.kotlin_module"
    )
    manifest {
        attributes(
            // 主类
            mapOf(
                "Main-Class" to "com.elouyi.sbboyohim.MainKt"
            )

        )
    }
}