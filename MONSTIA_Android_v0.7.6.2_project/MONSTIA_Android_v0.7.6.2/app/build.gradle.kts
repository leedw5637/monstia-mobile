plugins {
    id("com.android.application")
}

val updateUrl = providers.gradleProperty("MONSTIA_UPDATE_URL").orElse("").get()

android {
    namespace = "com.monstia.game"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.monstia.game"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "0.7.6.2"

        buildConfigField("String", "BUNDLED_GAME_VERSION", "\"0.7.6.2\"")
        buildConfigField("String", "UPDATE_MANIFEST_URL", "\"${updateUrl.replace("\\", "\\\\").replace("\"", "\\\"")}\"" )
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.core:core:1.15.0")
}

