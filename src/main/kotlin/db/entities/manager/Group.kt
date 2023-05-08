package db.entities.manager

import db.Handler
import java.lang.Exception
import db.entities.data.Group as Data


class Group(groupId: Int) : Data(groupId) {

    fun select(): Int {
        val sql = "SELECT * FROM GRUPOS WHERE GRUPOID = ?"
        val props = listOf<Int>(groupId)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun selectAll(): Int {
        TODO("Not yet implemented")
    }

    fun updatePoints(points: Int): Int {
        TODO("Not yet implemented")
    }


}