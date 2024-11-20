package robert.paba.latihan11

data class Task(
    val id: Int,
    var status: TaskStatus
)

enum class TaskStatus {
    TABLE1, TABLE2, TABLE3
}

