package entities

import javax.sql.DataSource

object Driver {

    private fun sizeProps(sql: String): Int {
        return sql.split("?").size - 1
    }

    fun modify(db: DataSource, sql: String, props: List<Int>): Int? {
        if (sizeProps(sql) < props.size) {
            return null
        }
        return db.connection.use { conn ->
            conn.prepareStatement(sql).use { stmt ->
                props.forEachIndexed { index, it ->
                    stmt.setString(index+1, it.toString())
                }
                stmt.executeUpdate()
            }
        }
    }

}