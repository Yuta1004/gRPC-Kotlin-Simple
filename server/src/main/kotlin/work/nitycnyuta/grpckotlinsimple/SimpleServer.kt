package work.nitycnyuta.grpckotlinsimple

import io.grpc.Server
import io.grpc.ServerBuilder

class SimpleServer(private val port: Int) {
    // GreeterServiceからServerオブジェクトを生成する => Serviceの実体化
    val server: Server = ServerBuilder
                .forPort(port)
                .addService(GreeterService())
                .build()

    // 起動処理
    //      - Serverの起動
    //      - JVM実行終了時に実行される処理としてサーバの終了処理を追加
    fun start() {
        server.start()
        println("SimpleServer started. (Port: $port)")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("!!! Shutting down SimpleServer since JVM is shutting down !!!")
                this@SimpleServer.stop()
                println("!!! Server shut down !!!")
            }
        )
    }

    // 終了処理 (外部からの終了は拒否)
    //      - サーバの終了処理を実行する
    private fun stop() {
        server.shutdown()
    }

    // サーバ起動後，JVM実行終了までプロセスを落とさない
    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    // GreeterServiceの動作を定義する
    // ↑のコードは毎回同じ，Serviceの定義が本質
    private class GreeterService : GreeterGrpcKt.GreeterCoroutineImplBase() {
        override suspend fun sayHello(request: HelloRequest) = HelloReply
                    .newBuilder()
                    .setMessage("Hello ${request.name}")
                    .build()

        override suspend fun sayHelloAgain(request: HelloRequest) = HelloReply
                    .newBuilder()
                    .setMessage("Hello?? ${request.name}")
                    .build()
    }
}
