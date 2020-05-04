package thuypham.n16dccn159.ptithcm.sellingapp.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import thuypham.n16dccn159.ptithcm.sellingapp.data.*

interface ApiManager {
    companion object {
        private const val BASE_URL = ""

        fun create(): ApiManager {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiManager::class.java)
        }
    }

    @FormUrlEncoded
    @POST("")
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): Call<Int>

//    @FormUrlEncoded
    @POST("")
    fun addOrder(
        @Body order: Order,
        @Body itemOrder: ArrayList<OrderItem>
    ): Call<Boolean>

    @POST("")
    fun signUp(user: User): Call<Int>

    @POST("")
    fun forgotPassword(email: String): Call<Int>

    @GET("")
    fun getListProductSale(): Call<ArrayList<Product>>

    @GET("")
    fun getAllProductSale(): Call<ArrayList<Product>>

    @GET("")
    fun getListProductOfCategory(cateId: Int): Call<ArrayList<Product>>

    @GET("")
    fun getProductDetailByID(productID: Int): Call<Product>

    @POST("")
    fun addCart(productID: Int): Call<Boolean>

    @GET("")
    fun getListOrder(userId: Int): Call<ArrayList<Product>>

    @GET("")
    fun getListSlider(): Call<ArrayList<Slide>>

    @GET("")
    fun getListCategory(): Call<ArrayList<Category>>

    @GET("")
    fun getCartCount(userID: Int): Call<Int>

    @POST("")
    fun minusCart(userID: Int, productID: Int): Call<Boolean>

    @POST("")
    fun plusCart(userID: Int, productID: Int): Call<Boolean>

    @DELETE("")
    fun delItemCart(userID: Int, productID: Int): Call<Boolean>

    @GET("")
    fun getProductsCart(userID: Int): Call<ArrayList<ProductCart>>
}