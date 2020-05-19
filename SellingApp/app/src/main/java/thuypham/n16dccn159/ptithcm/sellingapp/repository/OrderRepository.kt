package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderStatus
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultApi

interface OrderRepository {
    fun order(userID: Int,
              name: String,
              phone: String,
              email: String,
              address: String,
              note: String): Result<ResultApi>
    fun getAllOrder(userID: Int, statusID: Int?=null): Result<ArrayList<Order>>
    fun getAllOrderStatus(): Result<ArrayList<OrderStatus>>
}