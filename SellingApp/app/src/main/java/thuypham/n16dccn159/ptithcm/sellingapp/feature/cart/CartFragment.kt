package thuypham.n16dccn159.ptithcm.sellingapp.feature.cart

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_cart.*
import org.jetbrains.anko.support.v4.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.CartType
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.feature.cart.adapter.ProductCartAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.MainActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.product.ProductDetailActivity
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.CartViewModel

class CartFragment : Fragment() {

    private val cartViewModel: CartViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }

    private val cartAdapter: ProductCartAdapter by lazy {
        ProductCartAdapter { id, type -> eventsCart(id, type) }
    }

    private fun eventsCart(id: Int, type: CartType) {
        when (type) {
            CartType.DEL -> delItemCart(id)
            CartType.PLUS -> plusItemCart(id)
            CartType.MINUS -> minusItemCart(id)
            CartType.CLICK -> onClickItemCart(id)
        }
    }

    private fun onClickItemCart(id: Int) {
        val intent = Intent(requireContext(), ProductDetailActivity::class.java)
        intent.putExtra(PRODUCT_ID, id)
        startActivity(intent)
    }

    private fun minusItemCart(id: Int) {
        cartViewModel.minusCart(id, requireActivity().getIntPref(USER_ID))
    }

    private fun plusItemCart(id: Int) {
        cartViewModel.plusCart(id, requireActivity().getIntPref(USER_ID))
    }

    private fun delItemCart(id: Int) {
        cartViewModel.delCartItem(id, requireActivity().getIntPref(USER_ID))
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
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        addEvents()
        initViews()
    }

    private fun initViews() {
        rvProductCart.adapter = cartAdapter
        rvProductCart.setHasFixedSize(true)
        rvProductCart.setItemViewCacheSize(20)
    }

    private fun addEvents() {
        btnBackCart.setOnClickListener { requireActivity().onBackPressed() }
        btn_continue_shopping_cart.setOnClickListener { startActivity<MainActivity>() }
        btnOrderCart.setOnClickListener { showAddress() }
    }

    private fun showAddress() {
        requireActivity().replaceFragment(
            id = R.id.frmCart,
            fragment = AddressCartFragment(),
            addToBackStack = true
        )
    }

    private fun bindViewModel() {
        cartViewModel.productsCart.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                cartAdapter.setProductList(it)
                cartEmpty.gone()
            } else cartEmpty.visible()
        })

        cartViewModel.networkProductsCart.observe(viewLifecycleOwner, Observer {
            progressCart.visibility = if (it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })

        cartViewModel.networkPlusCart.observe(viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS)
                cartViewModel.getProductsCart(requireActivity().getIntPref(USER_ID))
        })

        cartViewModel.networkMinusCart.observe(viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS)
                cartViewModel.getProductsCart(requireActivity().getIntPref(USER_ID))
        })

        cartViewModel.networkDelCart.observe(viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS)
                cartViewModel.getProductsCart(requireActivity().getIntPref(USER_ID))
        })
    }
}
