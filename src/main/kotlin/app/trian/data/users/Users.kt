package app.trian.data.users


import org.jetbrains.exposed.sql.Table

object Users:Table() {
    val id = integer("id_user").autoIncrement()
    val uid=varchar("uid",255).uniqueIndex()
    val name= varchar("name",255)
    val provider = varchar("provider",255)
    val email =varchar("email",255)
    val lastLogin= long("last_login")
    val registerDate=long("registerDate")
    override val primaryKey = PrimaryKey(id)
}

data class User(
    val id:Int?,
    val uid:String,
    val name:String,
    val provider:String,
    val email:String,
    val lastlogin:Long,
    val registerDate:Long)