package app.trian.plugins

import app.trian.data.users.Activitys
import app.trian.data.users.UserProviders
import app.trian.data.users.Users
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(){
        Database.connect(hikarilocal())
        transaction {
            //user management
            create(Users)
            create(Activitys, Users)
            create(UserProviders, Users)
        }
    }
    private fun hikari():HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        config.jdbcUrl = String.format("jdbc:mysql:///%s", "db_trianapp")
        config.addDataSourceProperty("cloudSqlInstance", "myproject-64aac:asia-southeast2:dbtrianapp")
        config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory")
        config.addDataSourceProperty("ipTypes", "PUBLIC,PRIVATE")
        config.username = "dbtrianapp"
        config.password = "inipassword"

        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    private fun hikarilocal():HikariDataSource{
        val config = HikariConfig()
        config.driverClassName = "com.mysql.cj.jdbc.Driver"
        config.jdbcUrl = "jdbc:mysql://localhost:3306/db_trianapp"
        config.username = "root"
        config.password = ""

        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
}