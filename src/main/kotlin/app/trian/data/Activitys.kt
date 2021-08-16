package app.trian.data

import org.jetbrains.exposed.sql.Table

object Activitys :Table(){
    val id=integer("id_activity").autoIncrement()
    val userId = integer("user_id")
        .uniqueIndex()
        .references(Users.id)
    val lastLogin= long("last_login")
    val createdAt= long("cerated_at")
    override val primaryKey=PrimaryKey(id)
}

data class Activity(val id:Int,val userId:Int,val lastlogin:Long,val createdAt:Long)