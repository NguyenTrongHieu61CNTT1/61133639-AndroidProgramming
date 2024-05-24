plugins {
    id("com.android.application")
}

android {
    namespace = "ntu.mssv_61133639.hieumephim"
    compileSdk = 34

    defaultConfig {
        applicationId = "ntu.mssv_61133639.hieumephim"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.viewpager2:viewpager2:1.1.0") //Thư viện ViewPager2
    implementation("com.github.bumptech.glide:glide:4.14.2") //Thư viện bumptech/glide: tải hình ảnh và hiển thị lên ImageView
    implementation("com.android.volley:volley:1.2.1") //Thư viện volley: Kết nối và thao tác với network API
    implementation ("com.google.code.gson:gson:2.8.5") //Thư viện gson: java -> JSON
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}