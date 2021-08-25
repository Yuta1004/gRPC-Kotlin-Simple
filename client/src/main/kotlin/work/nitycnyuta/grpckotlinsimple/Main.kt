@file:JvmName("Main")

package work.nitycnyuta.grpckotlinsimple

import io.grpc.ManagedChannelBuilder

suspend fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50000).usePlaintext().build()
    val client = SimpleClient(channel)
    client.greet("ABC")
    client.greetAgain("ABC")
}
