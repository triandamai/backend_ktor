package app.trian.data.users

import org.jetbrains.exposed.sql.Table

object Activitys :Table(){
    val id=integer("id_activity").autoIncrement()
    val userId = reference("user_id", Users.id)
    val ip = varchar("ip_address",255)
    val mac = varchar("mac_address",255)
    val userAgent= varchar("user_agent",255)
    val createdAt= long("cerated_at")
    override val primaryKey=PrimaryKey(id)
}

data class Activity(val id:Int, val user: User, val lastlogin:Long, val createdAt:Long)