package app.trian

import io.ktor.application.*
import app.trian.plugins.*
import app.trian.services.UserService
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.routing.*


fun main(args: Array<String>): Unit =
    io.ktor.server.jetty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    //serializable
    install(ContentNegotiation){
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT,true)
        }
    }

    DatabaseFactory.init()
    val userService = UserService()
    install(Routing){
        configureRouting(userService)
    }
}
