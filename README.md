# gRPC Kotlin (Simple)


公式リポジトリ([grpc-kotlin](https://github.com/grpc/grpc-kotlin))の内容を理解するために，自分で1から作成したリポジトリです．  
出来る限り最低限の記述でServer，Clientを起動できるようにしたつもりです．

## Directories & Files

### gradle/

Gradle Wrapper用

### gradlew

gradlew実行ファイル(for Linux/MacOS)

### gradlew.bat

gradlew実行ファイル(for Windows)

### build.gradle.kts

ルートプロジェクト用ビルドスクリプト  
サブプロジェクトを含めた全てのプロジェクトに適用するビルド設定を書く

### settings.gradle.kts

Gradle設定ファイル  
そこまで書くことはなく，サブプロジェクトについての設定がほとんど

### protos/

`.proto`ファイル用プロジェクト
このディレクトリは`stub/`に使用される(=`stub/gradle.build.kts`によってビルドされる)

### protos/src

`.proto`ファイル配置用ディレクトリ

### protos/build.gradle.kts

ビルドスクリプト  
`stub/`によって使用される際に適用する設定を書く(`.proto`の配置場所を`protos/`に固定するなど)

### stub/

スタブ生成プロジェクト  
`protos/`を参照する

### stub/build.gradle.kts

スタブ生成用ビルドスクリプト  
`protobuf(project(":protos"))`の記述が`protos/`への参照を示す(=依存関係)

### stub/build/

スタブの生成結果などが配置されるディレクトリ  

### stub/buld/generated/

`.proto`ファイルを`protoc`によってコンパイルした結果の`.kt``.java`ファイルが配置されるディレクトリ

### stub/build/libs/

スタブを`.jar`にまとめたものが配置されるディレクトリ  
このディレクトリのパスをclasspathに追加することでServiceなどを定義することが出来る

## Commands

### `./gradlew tasks`

登録されているタスクの内，主要なものを表示する  
`--all`オプションを付けることで全てのタスクを表示する事ができる

### `./gradlew clean`

`build/`ディレクトリを削除する  
不意な削除操作を行わないようにディレクトリ指定することを推奨(`:<project>:clean`)


### `./gradlew :stub:generateProto`

`.ptoro`ファイルからstubを生成する  

**実行タスク**

```
Task :stub:extractIncludeProto
Task :protos:compileJava
Task :protos:processResources
Task :protos:classes
Task :protos:jar
Task :stub:extractProto
Task :stub:generateProto
```

### `./gradlew :stub:jar`

`.proto`ファイルからstubを生成し，さらに`.jar`ファイルを生成する  

**実行タスク**

```
Task :stub:extractIncludeProto
Task :protos:compileJava
Task :protos:processResources
Task :protos:classes
Task :protos:jar
Task :stub:extractProto
Task :stub:generateProto
Task :stub:compileKotlin
Task :stub:compileJava
Task :stub:processResources
Task :stub:classes
Task :stub:inspectClassesForKotlinIC
Task :stub:jar
```
