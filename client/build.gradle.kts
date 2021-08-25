plugins {
    application
    kotlin("jvm")
    id("com.google.protobuf")
}

dependencies {
    // stubプロジェクトへの依存 => classpathにstub/build/libsが追加される
    implementation(project(":stub"))

    implementation("com.google.protobuf:protobuf-kotlin:${rootProject.ext["protobufVersion"]}")
    implementation("io.grpc:grpc-kotlin-stub:${rootProject.ext["grpcKotlinVersion"]}")

    // 実行時のみnettyに依存(=実行時のみ有効化) (netty: 非同期通信アプリケーション用のフレームワーク)
    runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")
}

application {
    mainClass.set("work.nitycnyuta.grpckotlinsimple.Main")
}
