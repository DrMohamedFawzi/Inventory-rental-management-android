import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.DbConnection
import com.msnit.inventoryrentalmanagement.db.entity.Item
import com.msnit.inventoryrentalmanagement.items.ItemAdapterSecFrag
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SecondFragment : Fragment(), ItemAdapterSecFrag.OnItemClickListener, CoroutineScope {
    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapterSecFrag
    private val items = mutableListOf<Item>() // List to store items

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        adapter = ItemAdapterSecFrag(items, this)

        recyclerView = view.findViewById(R.id.recyclerViewtenant)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        launch {
            val itemDao = DbConnection.getDb(requireContext()).itemDao()
            addItems(itemDao.getAllItems())
        }

        return view
    }

    private fun addItems(_items: List<Item>) {
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

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancelChildren()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the toolbar
        val topAppBar = view.findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }
    }
}