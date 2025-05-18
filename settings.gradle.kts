pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven {
            url=uri("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }
    }
}

rootProject.name = "RisepopSimple"
include(":app")
 