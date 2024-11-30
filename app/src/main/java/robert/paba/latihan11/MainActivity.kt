package robert.paba.latihan11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import robert.paba.Latihan11.R

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: TaskAdapter
    private val tasks = mutableListOf(
        Task(1, TaskStatus.TABLE1),
        Task(2, TaskStatus.TABLE1),
        Task(3, TaskStatus.TABLE1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
