Risepop integrated access case

Step 1：

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

Step 2： dependencies add

    implementation("com.github.risepop:resome:1.0.4")

    //解析
    implementation("com.google.code.gson:gson:2.8.6")
//    网络请求
    api("com.squareup.okhttp3:okhttp:3.12.13")
    api("com.squareup.okhttp3:logging-interceptor:3.12.13")
//    缓存
    api("com.tencent:mmkv:1.3.7")

    api("androidx.legacy:legacy-support-v4:1.0.0")
    api("androidx.appcompat:appcompat:1.3.0-alpha02")
