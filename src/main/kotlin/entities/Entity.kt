package entities

interface Entity {
    fun create()
    fun select(id: Int)
    fun selectAll()
    fun update()
    fun delete(id: Int)
}