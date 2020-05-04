package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.ProductCart
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentConfirmOrderBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.USER_ID
import thuypham.n16dccn159.ptithcm.sellingapp.ext.getIntPref
import thuypham.n16dccn159.ptithcm.sellingapp.ext.replaceFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter.ProductCartConfirmAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.OrderViewModel

/**
 * A simple [Fragment] subclass.
 */
class ConfirmOrderFragment : Fragment() {


    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }
    private val orderViewModel : OrderViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideOrderViewModelFactory()
        )[OrderViewModel::class.java]
    }

    private var listProducts:ArrayList<Product> = arrayListOf()
    private var listItemOrder :ArrayList<OrderItem> = arrayListOf()
    private lateinit var binding: FragmentConfirmOrderBinding
    private val productAdapter: ProductCartConfirmAdapter by lazy {
        ProductCartConfirmAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cartViewModel.getProductsCart(requireActivity().getIntPref(USER_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feeShip= 20000F
        bindViewModel()
        addEvents()
        initViews()
    }

    private fun initViews() {
        binding.rvProductConfirm.adapter = productAdapter
        binding.rvProductConfirm.setHasFixedSize(true)
        binding.rvProductConfirm.setItemViewCacheSize(20)
    }

    private fun addEvents() {
        binding.btnBackConfirm.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnPaymentConf.setOnClickListener {
            addOrder()
            showOrderSuccess()
        }
    }

    private fun showOrderSuccess() {
        requireActivity().replaceFragment(
            id = R.id.frmCart,
            fragment = OrderSuccessFragment()
        )
    }

    private fun addOrder() {
        val order = Order().apply {
            name = cartViewModel.name
            phone = cartViewModel.phone
            email = cartViewModel.email
            address = cartViewModel.address
        }
        orderViewModel.addOrder(order, listItemOrder)
    }

    private fun bindViewModel() {
        cartViewModel.productsCart.observe(viewLifecycleOwner, Observer {
            productAdapter.setProductList(it)
            getTotalPrice(it)
        })

    }

    private fun getTotalPrice(arrProduct: ArrayList<ProductCart>) {
        var price: Float=0F
        var itemOrder : OrderItem
        for (product in arrProduct) {
            price += product.price!!
            itemOrder = OrderItem().apply {
                quantity = product.quantity
                unitPrice = product.price
                productId = product.id
            }
            listItemOrder.add(itemOrder)
        }
        binding.price= price
    }

}
