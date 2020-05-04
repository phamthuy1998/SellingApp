package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Order(
    @SerializedName("")
    var id: Int? = null,
    @SerializedName("")
    var buyDate: Date? = null,
    @SerializedName("")
    var name: String? = null,
    @SerializedName("")
    var phone: String? = null,
    @SerializedName("")
    var email: String? = null,
    @SerializedName("")
    var address: String? = null,
    @SerializedName("")
    var note: String? = null,
    @SerializedName("")
    var statusID: Boolean? = null
)

data class OrderItem(
    @SerializedName("")
    var id: Int? = null,
    @SerializedName("")
    var quantity: Int? = null,
    @SerializedName("")
    var unitPrice: Float? = null,
    @SerializedName("")
    var productId: Int? = null,
    @SerializedName("")
    var orderID: Int? = null
)

data class StatusOrder(
    var id: Int?=null,
    var statusName: String?=null
)