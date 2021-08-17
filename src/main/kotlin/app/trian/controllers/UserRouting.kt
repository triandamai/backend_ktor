package app.trian.controllers

import app.trian.data.users.User

import app.trian.services.UserService
import com.google.gson.JsonObject
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.request.*
import org.valiktor.functions.isEmail
import org.valiktor.functions.isNotEmpty
import org.valiktor.validate


fun Application.configureRouting(userService: UserService) {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/login"){

            call.respond(userService.getAllUsers())
        }
        post("/register") {
            val user = call.receive<User>()
            val validation = validate(user){
                validate(User::name).isNotEmpty()
                validate(User::email).isEmail()
                validate(User::username).isNotEmpty()
                validate(User::password).isNotEmpty()
            }
            call.respond(user)
        }
    }
}
