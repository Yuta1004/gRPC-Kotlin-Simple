// 使用するPlugin => pluginsブロックに記述
// 基本的には完全名前解決可能なidを指定するが，特別なPlugin(=Core Plugin)は略称で良い
// apply=falseを指定することで単にクラスパスへ追加するだけという挙動になり，Plugin.Applyは実行されない
//     => マルチプロジェクト構成にするときはこのようにする
//     => Plugin.Applyが実行される際，ProjectにTaskが追加されたりする
plugins {
    id("com.google.protobuf") version "0.8.17" apply false
    kotlin("jvm") version "1.5.21" apply false
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1" apply false
    "java-library"
}

// 独自プロパティの定義 => Project.extに定義する
ext["grpcVersion"] = "1.37.0"
ext["grpcKotlinVersion"] = "1.1.0"
ext["protobufVersion"] = "3.17.0"

// サブプロジェクト全体に適用する設定 => subprojectsブロック内に記述
subprojects {
    // Plugin参照先リポジトリの記述
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    // 設定implementationはjavaPluginに登録されている
    apply(plugin = "java")

    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
