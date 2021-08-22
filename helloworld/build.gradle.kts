import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

// helloworldプロジェクトで使用するPlugin => pluginsブロックに記述
//      => ルートプロジェクトでバージョン指定をしているためここで特別な記述は不要
plugins {
    application
    kotlin("jvm")
}

// applicationプラグインの設定 => applicationブロックに記述
application {
    getMainClass().set("work.nitycnyuta.helloworld.Main")
}

// 依存関係解決 => dependenciesブロックに記述
dependencies {
    testImplementation(kotlin("test"))
}

// Type:Testのタスクについての設定を行う (ここではテスト結果を標準出力に出力するようにしている)
tasks.withType<Test> {
    testLogging {
        events(TestLogEvent.FAILED, TestLogEvent.SKIPPED, TestLogEvent.PASSED)
        exceptionFormat = TestExceptionFormat.FULL
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
    useJUnitPlatform()
}
