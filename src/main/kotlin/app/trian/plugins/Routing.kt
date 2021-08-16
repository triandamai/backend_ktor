package app.trian.plugins

import app.trian.services.UserService
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting(userService: UserService) {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/tes"){
            call.respond(userService.getAllUsers())
        }
    }
}
