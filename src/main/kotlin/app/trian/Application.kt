package app.trian

import app.trian.controllers.configureRouting
import io.ktor.application.*
import app.trian.plugins.*
import app.trian.services.UserService

import io.ktor.features.*
import io.ktor.gson.*

import io.ktor.routing.*


fun main(args: Array<String>): Unit =
    io.ktor.server.jetty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    //serializable
    install(ContentNegotiation){
        gson {
            setLenient()
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    DatabaseFactory.init()
    val userService = UserService()
    install(Routing){
        configureRouting(userService)
    }
}
