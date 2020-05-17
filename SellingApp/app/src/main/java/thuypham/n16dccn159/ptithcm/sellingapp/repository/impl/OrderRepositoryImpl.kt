package thuypham.n16dccn159.ptithcm.sellingapp.repository.impl

import androidx.lifecycle.MutableLiveData
import thuypham.n16dccn159.ptithcm.sellingapp.data.NetworkState
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.repository.OrderRepository
import thuypham.n16dccn159.ptithcm.sellingapp.service.ApiService

class OrderRepositoryImpl(private val apiService: ApiService) : OrderRepository {
    override fun order(order: Order, itemOrder: ArrayList<OrderItem>): Result<Boolean> {
        val networkState = MutableLiveData<NetworkState>()
        val responseLogin = MutableLiveData<Boolean>()
        apiService.addOrder(
            order, itemOrder,
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                responseLogin.value = response
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )

        return Result(
            data = responseLogin,
            networkState = networkState
        )
    }

    override fun getAllOrder(): Result<ArrayList<Order>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}