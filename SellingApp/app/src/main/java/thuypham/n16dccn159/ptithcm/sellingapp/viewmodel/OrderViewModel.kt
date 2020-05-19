package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderStatus
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultApi
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository

class OrderViewModel(private val repository: OrderRepository) : ViewModel() {


    private val requestOrder = MutableLiveData<Result<ResultApi>>()

    val dataCheckOut = Transformations.switchMap(requestOrder) {
        it.data
    }
    val networkCheckOut = Transformations.switchMap(requestOrder) {
        it.networkState
    }

    fun addOrder(
        userID: Int,
        name: String,
        phone: String,
        email: String,
        address: String,
        note: String
    ) {
        requestOrder.value = repository.order(userID, name, phone, email, address, note)
    }

    /*         GET ALL STATUS OF ORDER    */
    private val requestStatusOrder = MutableLiveData<Result<ArrayList<OrderStatus>>>()

    val dataStatusOrder = Transformations.switchMap(requestStatusOrder) {
        it.data
    }
    val networkStatusOrder = Transformations.switchMap(requestStatusOrder) {
        it.networkState
    }

    fun getAllStatusOrder() {
        requestStatusOrder.value = repository.getAllOrderStatus()
    }


    /*         GET ALL ORDER    */
    private val requestAllOrders = MutableLiveData<Result<ArrayList<Order>>>()

    val listOrder = Transformations.switchMap(requestAllOrders) {
        it.data
    }
    val networkListOrder = Transformations.switchMap(requestAllOrders) {
        it.networkState
    }

    fun getAllOrder(userID: Int, statusID: Int?=null) {
        requestAllOrders.value = repository.getAllOrder(userID, statusID)
    }
}


class OrderViewModelFactory(
    private val repository: OrderRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = OrderViewModel(repository) as T
}