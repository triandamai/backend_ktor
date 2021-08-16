package app.trian.data

import org.jetbrains.exposed.sql.Table

object Users:Table() {
    val id = integer("id_user").autoIncrement()
    val provider = varchar("provider",255)
    val uid=varchar("uid",255)
    val name= varchar("name",255)
    val email =varchar("email",255)
    val registerDate=long("registerDate")
    override val primaryKey = PrimaryKey(id)
}

data class User(
    val id:Int,
    val name:String,
    val registerDate:Long)