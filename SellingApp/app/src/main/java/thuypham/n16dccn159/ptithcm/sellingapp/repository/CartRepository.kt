package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Result

interface CartRepository {
    fun getCartCount(userID: Int):  Result<Int>
    fun getProductCart(userID: Int): Result<ArrayList<Product>>
}