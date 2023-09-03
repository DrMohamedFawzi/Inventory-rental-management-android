import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.msnit.inventoryrentalmanagement.R

class FirstFragment : Fragment() {

    private lateinit var view: View
    private lateinit var firstButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // تضخيم الواجهة لهذا الفراغ الفرعي
        view = inflater.inflate(R.layout.fragment_first, container, false)

        // الحصول على مرجع الزر من الواجهة
        firstButton = view.findViewById(R.id.firstdButton)

        // تعيين مستمع للنقر على الزر
        firstButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Clicked on First Fragment", Toast.LENGTH_SHORT).show()
        })

        return view
    }
}