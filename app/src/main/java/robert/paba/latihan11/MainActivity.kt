package robert.paba.latihan11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private val tasks = mutableListOf(
        Task(1, TaskStatus.TABLE1),
        Task(2, TaskStatus.TABLE1),
        Task(3, TaskStatus.TABLE1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = TaskAdapter(tasks,
            onKerjakanClick = { task ->
                task.status = TaskStatus.TABLE2
                adapter.notifyDataSetChanged()
            },
            onSelesaiClick = { task ->
                task.status = TaskStatus.TABLE3
                adapter.notifyDataSetChanged()
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
