plugins {
    id("com.android.application")
}

android {
    namespace = "com.worldcrisis.whitehouse"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.worldcrisis.whitehouse"
        minSdk = 24
        targetSdk = 35
        versionCode = 7
        versionName = "0.7-beta"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
