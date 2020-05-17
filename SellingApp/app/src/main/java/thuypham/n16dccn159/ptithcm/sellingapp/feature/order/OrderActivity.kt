package thuypham.n16dccn159.ptithcm.sellingapp.feature.order

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ll_cart.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setEvents()
    }

    private fun setEvents() {
        ll_cart_number.setOnClickListener { startActivity<CartActivity>() }
    }

    fun onclickBack(view: View) { finish()}


}
