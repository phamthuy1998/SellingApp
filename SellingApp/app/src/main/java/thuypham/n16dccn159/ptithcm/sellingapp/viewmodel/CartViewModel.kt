package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.CartRepository

class CartViewModel(private val repository: CartRepository) : ViewModel() {

    private val requestCartCount = MutableLiveData<Result<Int>>()
    private val requestProductsCart = MutableLiveData<Result<ArrayList<Product>>>()

    val cartCount = Transformations.switchMap(requestCartCount) {
        it.data
    }

    fun getCartCount(userID: Int) {
        requestCartCount.value = repository.getCartCount(userID)
    }

    val productsCart = Transformations.switchMap(requestProductsCart) {
        it.data
    }
    val networkProductsCart = Transformations.switchMap(requestProductsCart) {
        it.networkState
    }

    fun getProductsCart(userID: Int) {
        requestProductsCart.value = repository.getProductCart(userID)
    }
}

class CartViewModelFactory(
    private val repository: CartRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = CartViewModel(repository) as T
}