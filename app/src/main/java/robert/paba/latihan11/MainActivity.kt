package robert.paba.latihan11

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import robert.paba.Latihan11.R

class MainActivity : AppCompatActivity() {

    private lateinit var rvTask: RecyclerView
    private lateinit var TaskAdapter: taskAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        _rvTask = findViewById(R.id.rvTask)

//        val tvNamaTask = findViewById<TextView>(R.id.tvNama)
//        val tvTanggal = findViewById<TextView>(R.id.tvTanggal)
//        val tvKategori = findViewById<TextView>(R.id.tvKategori)
//        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsi)

        // Ambil data dari SharedPreferences
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val namaTask = sharedPreferences.getString("namaTask", "Tidak ada data") ?: "Tidak ada data"
        val tanggal = sharedPreferences.getString("tanggal", "Tidak ada data") ?: "Tidak ada data"
        val kategori = sharedPreferences.getString("kategori", "Tidak ada data") ?: "Tidak ada data"
        val deskripsi = sharedPreferences.getString("deskripsi", "Tidak ada data") ?: "Tidak ada data"

        // Buat daftar task
        val taskList = listOf(
            Task(namaTask, tanggal, kategori, deskripsi)
        )

        // Atur Adapter dan LayoutManager untuk RecyclerView
        TaskAdapter = taskAdapter(taskList)
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = TaskAdapter

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private lateinit var _nama : Array<String>
    private lateinit var _tanggal : Array<String>
    private lateinit var _kategori : Array<String>
    private lateinit var _deskripsi : Array<String>

    private var arTask = arrayListOf<Task>()

    private lateinit var _rvTask : RecyclerView
}
