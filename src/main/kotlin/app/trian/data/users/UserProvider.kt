package app.trian.data.users


import org.jetbrains.exposed.sql.Table

object UserProviders : Table(){
    val id= integer("id_activity").autoIncrement()
    val userId = reference("user_id", Users.id).uniqueIndex()
    val username = varchar("username",255)
    val password = varchar("password",255)
    val createdAt= long("cerated_at")
    val updatedAt= long("updated_at")
    override val primaryKey=PrimaryKey(id)
}

data class UserProvider(
    val id:Int,
    val user: User,
    val username:String,
    val password:String,
    val createdAt:Long,
    val updatedAt: Long
)