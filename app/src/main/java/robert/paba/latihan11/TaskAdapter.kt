package robert.paba.latihan11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import robert.paba.Latihan11.R

class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onKerjakanClick: (Task) -> Unit,
    private val onSelesaiClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btnKerjakan: Button = itemView.findViewById(R.id.btnKerjakan)
        private val btnSelesai: Button = itemView.findViewById(R.id.btnSelesai)
        private val btnUbah: Button = itemView.findViewById(R.id.btnUbah)
        private val btnHapus: Button = itemView.findViewById(R.id.btnHapus)

        fun bind(task: Task) {
            when (task.status) {
                TaskStatus.TABLE1 -> {
                    btnKerjakan.visibility = View.VISIBLE
                    btnSelesai.visibility = View.GONE
                    btnUbah.visibility = View.VISIBLE
                    btnHapus.visibility = View.VISIBLE
                }
                TaskStatus.TABLE2 -> {
                    btnKerjakan.visibility = View.GONE
                    btnSelesai.visibility = View.VISIBLE
                    btnUbah.visibility = View.VISIBLE
                    btnHapus.visibility = View.VISIBLE
                }
                TaskStatus.TABLE3 -> {
                    btnKerjakan.visibility = View.GONE
                    btnSelesai.visibility = View.GONE
                    btnUbah.visibility = View.GONE
                    btnHapus.visibility = View.GONE
                }
            }

            btnKerjakan.setOnClickListener { onKerjakanClick(task) }
            btnSelesai.setOnClickListener { onSelesaiClick(task) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}
