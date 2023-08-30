import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.msnit.inventoryrentalmanagement.R

class SecondFragment : Fragment() {

    private lateinit var view: View
    private lateinit var secondButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // تضخيم الواجهة لهذا الفراغ الفرعي
        view = inflater.inflate(R.layout.fragment_second, container, false)

        // الحصول على مرجع الزر من الواجهة
        secondButton = view.findViewById(R.id.secondButton)

        // تعيين مستمع للنقر على الزر
        secondButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Clicked on Second Fragment", Toast.LENGTH_SHORT).show()
        })

        return view
    }
}