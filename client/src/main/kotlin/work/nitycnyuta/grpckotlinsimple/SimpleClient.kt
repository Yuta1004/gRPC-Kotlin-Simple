package work.nitycnyuta.grpckotlinsimple

import io.grpc.ManagedChannel
import java.io.Closeable
import java.util.concurrent.TimeUnit
import work.nitycnyuta.grpckotlinsimple.GreeterGrpcKt.GreeterCoroutineStub

class SimpleClient(private val channel: ManagedChannel) : Closeable {
    // channelからスタブ(stub)を生成する
    //      => channel = 接続先情報をもつ(ManagedChannel)
    private val stub: GreeterCoroutineStub = GreeterCoroutineStub(channel)

    suspend fun greet(name: String) {
        val req = HelloRequest.newBuilder().setName(name).build()
        val resp = stub.sayHello(req)
        println("Received: ${resp.message}")
    }

    suspend fun greetAgain(name: String) {
        val req = HelloRequest.newBuilder().setName(name).build()
        val resp = stub.sayHelloAgain(req)
        println("Received: ${resp.message}")
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}
