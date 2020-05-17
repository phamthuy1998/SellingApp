package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Order
import thuypham.n16dccn159.ptithcm.sellingapp.data.OrderItem
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result

interface OrderRepository {
    fun order(order: Order, itemOrder: ArrayList<OrderItem>): Result<Boolean>
    fun getAllOrder(): Result<ArrayList<Order>>
}