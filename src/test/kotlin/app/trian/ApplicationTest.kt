package app.trian

import app.trian.controllers.configureRouting
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import app.trian.services.UserService

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting(UserService()) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}