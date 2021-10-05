
buildscript {

    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }
}

allprojects {

    group = "com.elouyi"
    version = "0.0.1"

    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral()
    }
}
