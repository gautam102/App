import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.models.BloodReport
import com.example.app.models.CBCParams
import com.example.app.models.CMPParams
import com.example.app.models.LipidParams
import com.example.app.models.ThyroidParams

class BloodReportsViewModel : ViewModel() {
    private val _bloodReportsLiveData = MutableLiveData<List<BloodReport>>()

    // Expose LiveData to observe in the activity
    val bloodReportsLiveData: LiveData<List<BloodReport>>
        get() = _bloodReportsLiveData

    init {
        // Simulate fetching data and updating the LiveData

    }
}
