package app.trian.services

import app.trian.data.users.User
import app.trian.data.users.Users
import app.trian.plugins.ResponseFactory
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserService {
    suspend fun getAllUsers():ResponseFactory<List<User>> = newSuspendedTransaction {
       val user =  Users.selectAll().map {
           toUser(it)
       }
        ResponseFactory(code = if(user.size > 1) 200 else 400,message = "",data = user)

    }
    suspend fun createNewUser(){

    }

    private fun toUser(row:ResultRow): User {
        return User(
            id = row[Users.id],
            uid=row[Users.uid],
            name = row[Users.name],
            email=row[Users.email],
            provider=row[Users.provider],
            username=row[Users.username],
            password=row[Users.password],
            lastlogin=row[Users.lastLogin],
            registerDate = row[Users.registerDate]
        )
    }
}