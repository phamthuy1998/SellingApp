package thuypham.n16dccn159.ptithcm.sellingapp.feature.order

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.ll_cart.*
import org.jetbrains.anko.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderStatus
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.CartActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.order.adapter.OrderAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {
    private val orderViewModel: OrderViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideOrderViewModelFactory()
        )[OrderViewModel::class.java]
    }

    private val orderAdapter: OrderAdapter by lazy {
        OrderAdapter() { order -> onItemClick(order) }
    }

    private fun onItemClick(order: Order) {

    }

    private var statusOrder: OrderStatus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        statusOrder = intent.getParcelableExtra(ORDER_STATUS)
        initViews()
        getDataByStatus()
        setEvents()
        bindViewModel()
    }

    private fun bindViewModel() {
        orderViewModel.listOrder.observe(this){

        }
        orderViewModel.networkListOrder.observe(this){
            when (it.status) {
                Status.RUNNING -> progressOrder.visible()
                Status.SUCCESS -> {
                    progressOrder.gone()
                }
                Status.FAILED -> {
                    progressOrder.gone()
                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun initViews() {
        rvOrder.adapter = orderAdapter
        rvOrder.setHasFixedSize(true)
        rvOrder.setItemViewCacheSize(20)
    }

    private fun getDataByStatus() {
        if (statusOrder == null) {
            orderViewModel.getAllOrder(getIntPref(USER_ID))
            tvTbOrder.text = getString(R.string.order_management)
        } else {
            orderViewModel.getAllOrder(getIntPref(USER_ID))
            tvTbOrder.text = statusOrder?.statusName
        }
    }

    private fun setEvents() {
        ll_cart_number.setOnClickListener { startActivity<CartActivity>() }
        swRefreshOrder.setOnRefreshListener {
            getDataByStatus()
            swRefreshOrder.isRefreshing = false
        }
    }

    fun onclickBack(view: View) {
        finish()
    }


}
