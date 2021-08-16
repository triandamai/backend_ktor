package app.trian.services

import app.trian.data.User
import app.trian.data.Users
import app.trian.plugins.ResponseFactory
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserService {
    suspend fun getAllUsers():ResponseFactory<List<User>> = newSuspendedTransaction {
       val user =  Users.selectAll().map {
           toUser(it)
       }
        ResponseFactory(code = if(user.size > 1) 200 else 400,message = "",data = user)

    }

    suspend fun insertUser(user: User):ResponseFactory<User?> = newSuspendedTransaction {
        val simpan = Users.insert {
            it[name] = user.name
            it[registerDate] = System.currentTimeMillis()
        }
        val success = simpan.insertedCount > 1
        ResponseFactory(code = if(success)  200 else 400,message="",data=if(success) toUser(simpan.resultedValues?.get(0)!!) else null)
    }

    private fun toUser(row:ResultRow):User{
        return User(
            id = row[Users.id],
            name = row[Users.name],
            registerDate = row[Users.registerDate]
        )
    }
}