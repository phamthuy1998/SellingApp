package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

class EditProfileActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideAuthViewModelFactory()
        )[UserViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    fun onBack(view: View) {}
}
