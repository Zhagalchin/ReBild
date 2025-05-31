pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "ReBild"
include(":app")
include(":core-network-api")
include(":core-network-impl")
include(":core-database-api")
include(":core-database-impl")
include(":core-common")
include(":feature-products-api")
include(":feature-products-impl")
include(":core-navigation-api")
include(":core-navigation-impl")
