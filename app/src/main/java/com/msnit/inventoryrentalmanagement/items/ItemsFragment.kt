import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.DbConnection
import com.msnit.inventoryrentalmanagement.db.entity.Item
import com.msnit.inventoryrentalmanagement.items.ItemAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ItemsFragment : Fragment(), ItemAdapter.OnItemClickListener ,
    CoroutineScope {
    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val items = mutableListOf<Item>() // List to store items

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_items, container, false)





        adapter = ItemAdapter(items, this)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter


        launch {
            val itemDao = DbConnection.getDb(context).itemDao()
             addItems(itemDao.getAllItems())
        }
        return view
    }

    fun addItems(_items :List<Item>) {
        items.addAll(_items)
        adapter.notifyDataSetChanged()
    }
    fun addItem(item: Item) {
        items.add(item)
        adapter.notifyItemInserted(items.size - 1)
    }

    private fun removeItem(position: Int) {
        items.removeAt(position)
        adapter.notifyItemRemoved(position)
    }




    override fun onItemClick(item: Item) {
        Toast.makeText(requireContext(), "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()
    }
}