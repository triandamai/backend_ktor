package app.trian.services

import app.trian.data.users.User
import app.trian.data.users.UserProvider
import app.trian.data.users.UserProviders
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
    suspend fun createNewUser(){}

    suspend fun login(username:String,password:String){
       val user = (UserProviders innerJoin Users).select { UserProviders.username.eq(username) and UserProviders.password.eq(password) }

    }
    private fun toUser(row:ResultRow): User {
        return User(
            id = row[Users.id],
            uid=row[Users.uid],
            name = row[Users.name],
            provider= row[Users.provider],
            email=row[Users.email],
            lastlogin=row[Users.lastLogin],
            registerDate = row[Users.registerDate]
        )
    }
}