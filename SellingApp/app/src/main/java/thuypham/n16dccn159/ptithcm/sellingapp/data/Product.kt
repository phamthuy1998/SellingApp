package thuypham.n16dccn159.ptithcm.sellingapp.data

import com.google.gson.annotations.SerializedName
import thuypham.n16dccn159.ptithcm.sellingapp.base.DynamicSearchAdapter

data class Product(
    @SerializedName("")
    val id: Int? = null,
    @SerializedName("")
    val name: String? = null,
    @SerializedName("")
    val price: Float? = null,
    @SerializedName("")
    val discount: Float? = null,
    @SerializedName("")
    val cateId: Int? = null,
    @SerializedName("")
    val description: String? = null,
    @SerializedName("")
    val information: String? = null,
    @SerializedName("")
    val image: String? = null,
    @SerializedName("")
    val display: String? = null,
    @SerializedName("")
    val stock: Int? = null
) : DynamicSearchAdapter.Searchable {
    override fun getSearchCriteria(): String = name ?: ""
    override fun toString() = name ?: ""
}