package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.USER_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.getIntPref
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel

class CartActivity : AppCompatActivity() {

    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        cartViewModel.getProductsCart(getIntPref(USER_ID))
        bindViewModel()
        addEvents()
        initViews()
    }

    private fun initViews() {

    }

    private fun addEvents() {

    }

    private fun bindViewModel() {

    }
}
