package db

import java.sql.Connection
import java.sql.DriverManager

object Handler {

    private fun link(): Connection {
        return DriverManager.getConnection("jdbc:h2:./db", "lolo", "escobar")
    }

    private fun sizeProps(sql: String): Int {
        return sql.split("?").size - 1
    }

    fun query(sql: String, props: List<Int>): Int {
        if (sizeProps(sql) < props.size) {
            return 0
        }
        return link().use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                props.forEachIndexed { index, it ->
                    stmt.setString(index+1, it.toString())
                }
                stmt.executeUpdate()
            }
        }
    }

}