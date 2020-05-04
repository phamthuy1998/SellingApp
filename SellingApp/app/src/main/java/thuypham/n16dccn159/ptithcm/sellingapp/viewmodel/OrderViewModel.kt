package thuypham.n16dccn159.ptithcm.sellingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository

class OrderViewModel(private val repository: OrderRepository) :ViewModel(){


    private val requestOrder = MutableLiveData<Result<Boolean>>()

    fun addOrder(order: Order, itemOrder: ArrayList<OrderItem>){
        requestOrder.value = repository.order(order, itemOrder)
    }
}



class OrderViewModelFactory(
    private val repository: OrderRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = OrderViewModel(repository) as T
}