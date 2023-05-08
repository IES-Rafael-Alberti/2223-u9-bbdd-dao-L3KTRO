package user

import db.entities.manager.CTF
import db.entities.manager.Group

class CLI {

    private fun add(ctfId: Int, groupId: Int, points: Int) {
        val res = CTF(ctfId).create(groupId, points)
        return if(res == 1){
            out("Procesado")
        } else {
            out("Error al procesar la petición")
        }
    }

    private fun del(ctfId: Int, groupId: Int) {
        val res = CTF(ctfId).deleteGroup(groupId)
        return if(res == 1){
            out("Procesado")
        } else {
            out("Error al procesar la petición")
        }
    }

    private fun list(groupId: Int) {
        val res = Group(groupId).select()
        return if(res == 1){
            out("Procesado")
        } else {
            out("Error al procesar la petición")
        }
    }

    fun start(args: Array<String>) {
        val opt = args[0]
        val copied = args.toMutableList().drop(1)
        val parsed = List<Int>(copied.size) { copied[it].toInt() }

        if (parsed.isEmpty()) {
            error("Faltan argumentos.")
        } else when (opt) {
            "-a" -> {
                return if (parsed.size != 3) error("La cantidad de argumentos no es correcta.")
                else {
                    val ctfid = parsed[0]
                    val groupid = parsed[1]
                    val points = parsed[2]
                    add(ctfid, groupid, points)
                }
            }

            "-d" -> {
                return if (parsed.size != 2) error("La cantidad de argumentos no es correcta.")
                else {
                    val ctfid = parsed[0]
                    val groupid = parsed[1]
                    del(ctfid, groupid)
                }
            }

            "-l" -> {
                return if (parsed.size != 1) error("La cantidad de argumentos no es correcta.")
                else {
                    val groupid = parsed[0]
                    list(groupid)
                }
            }

            else -> return error("Opcion incorrecta.", true)
        }
    }

    private fun out(str: String){
        return println(str)
    }

    private fun error(err: String, help: Boolean) {
        val red = "\u001B[31m"
        val reset = "\u001b[0m"
        println("$red ERROR: $err $reset")
        if (help) help()
    }

    private fun help() {
        println()
        println()
        println("AYUDA:")
        println()
        println("-a <ctfid> <grupoId> <puntuacion>")
        println("Añade una participación del grupo <grupoid> en el CTF <ctfid> con la puntuación <puntuacion>. Recalcula el campo mejorposCTFid de los grupos en la tabla GRUPOS.")
        println()
        println("-d <ctfid> <grupoId>")
        println("Elimina la participación del grupo <grupoid> en el CTF <ctfid>. Recalcula el campo mejorposCTFid de los grupos en la tabla GRUPOS.")
        println()
        println("-l <grupoId>")
        println("Si <grupoId> esta presente muestra la información del grupo <grupoId>, sino muestra la información de todos los grupos.")
        println()
    }
}