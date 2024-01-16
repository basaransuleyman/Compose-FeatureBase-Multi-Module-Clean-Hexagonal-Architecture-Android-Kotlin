pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeFeatureBasedMultiModule"
include(":app")
include(":navigation")
include(":core")
include(":home")
include(":list")
include(":network")
include(":detail")
