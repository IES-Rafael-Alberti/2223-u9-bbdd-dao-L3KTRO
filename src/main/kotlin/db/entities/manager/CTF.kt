package db.entities.manager

import db.Handler
import java.lang.Exception
import db.entities.data.CTF as Data


class CTF(id: Int) : Data(id) {
    fun create(groupId: Int, points: Int): Int {
        val sql = "INSERT INTO CTFS (CTFID, GRUPOID, PUNTUACION) VALUES (?, ?, ?)"
        val props = listOf<Int>(id, groupId, points)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun select(): Int {
        val sql = "SELECT * FROM CTFS WHERE CTFID = ?"
        val props = listOf<Int>(id)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun selectAll(): Int {
        val sql = "SELECT * FROM CTFS"
        val props = listOf<Int>()
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun update(groupId: Int, points: Int): Int {
        val sql = "UPDATE CTFS SET GRUPOID = ?, PUNTUACION = ? WHERE CTFID = ?"
        val props = listOf<Int>(groupId, points, id)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun delete(): Int {
        val sql = "DELETE FROM CTFS WHERE CTFID = ?"
        val props = listOf<Int>(id)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }

    fun deleteGroup(groupId: Int) : Int {
        val sql = "DELETE FROM CTFS WHERE GRUPOID = ?"
        val props = listOf<Int>(id)
        return try {
            Handler.query(sql, props)
        } catch (_: Exception) {
            0
        }
    }


}