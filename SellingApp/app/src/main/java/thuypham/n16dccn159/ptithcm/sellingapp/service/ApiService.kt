package thuypham.n16dccn159.ptithcm.sellingapp.service

import thuypham.n16dccn159.ptithcm.sellingapp.data.*

class ApiService(private val apiApi: ApiManager) {

    fun getListProductSale(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductSale()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListSlide(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Slide>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListSlider()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getAllListProductSale(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductSale()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
    fun getAllPros(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getAllProducts()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListProductCategory(
        cateId: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListProductOfCategory(cateId)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getProductDetailByID(
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Product>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getProductDetailByID(productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun addCart(
        productID: Int,
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.addCart(productID, userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getListCategory(
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<Category>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getListCategory()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getCartCount(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Int?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getCartCount(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun minusCart(
        userID: Int,
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.minusCart(userID, productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun plusCart(
        userID: Int,
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.plusCart(userID, productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun delCart(
        userID: Int,
        productID: Int,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.delItemCart(userID, productID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getProductCart(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<ProductCart>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getProductsCart(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun login(
        email: String,
        password: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultLogin?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.login(email, password)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun addOrder(
        order: Order, itemOrder: ArrayList<OrderItem>,
        onPrepared: () -> Unit,
        onSuccess: (Boolean?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.addOrder(order, itemOrder)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun forgotPassword(
        email: String,
        onPrepared: () -> Unit,
        onSuccess: (Int?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.forgotPassword(email)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
    fun getUserInfoByUserID(
        userID: Int,
        onPrepared: () -> Unit,
        onSuccess: (ArrayList<User>?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.getUserInfoByUserID(userID)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String,
        onPrepared: () -> Unit,
        onSuccess: (ResultLogin?) -> Unit,
        onError: (String) -> Unit
    ) {
        val request = apiApi.signUp(username, password, name, email, phone, address)
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
}