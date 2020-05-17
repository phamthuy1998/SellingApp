package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("Id")
    var id: Int? = null,
    @SerializedName("UserId")
    var userID: Int? = null,
    @SerializedName("BuyDate")
    var buyDate: String? = null,
    @SerializedName("Name")
    var name: String? = null,
    @SerializedName("Phone")
    var phone: String? = null,
    @SerializedName("Email")
    var email: String? = null,
    @SerializedName("Address")
    var address: String? = null,
    @SerializedName("Note")
    var note: String? = null,
    @SerializedName("StatusId")
    var statusID: Int? = null
)

data class OrderItem(
    @SerializedName("Id")
    var id: Int? = null,
    @SerializedName("Quantity")
    var quantity: Int? = null,
    @SerializedName("UnitPrice")
    var unitPrice: Float? = null,
    @SerializedName("ProId")
    var productId: Int? = null,
    @SerializedName("OrderId")
    var orderID: Int? = null
)

data class StatusOrder(
    var id: Int?=null,
    var statusName: String?=null
)