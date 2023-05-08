package entities.manager

import javax.sql.DataSource
import entities.data.CTF as Data


class CTF(private val db: DataSource, id: Int, groupId: Int, points: Int) : Data(id, groupId, points) {
    override fun create() {
        val sql = "INSERT INTO CTFS (CTFID, GRUPOID, PUNTUACION) VALUES (?, ?, ?)"
    }

    override fun select(id: Int) {
        TODO("Not yet implemented")
    }

    override fun selectAll() {
        TODO("Not yet implemented")
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }


}