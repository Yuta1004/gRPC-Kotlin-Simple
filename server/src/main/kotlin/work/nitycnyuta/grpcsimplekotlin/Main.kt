@file:JvmName("Main")

package work.nitycnyuta.grpckotlinsimple

fun main() {
    val server = SimpleServer(50000)
    server.start()
    server.blockUntilShutdown()
}
