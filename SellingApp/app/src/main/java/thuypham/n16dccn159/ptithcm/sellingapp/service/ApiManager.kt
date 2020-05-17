package thuypham.n16dccn159.ptithcm.sellingapp.service

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import thuypham.n16dccn159.ptithcm.sellingapp.data.*

interface ApiManager {
    companion object {

        private const val localhost = "192.168.1.19"
        private const val BASE_URL = "http://$localhost:800/api/"

        fun create(): ApiManager {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            Log.d("BASE_URL", BASE_URL)
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

    @GET("login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<ResultLogin>

    //    @FormUrlEncoded
    @POST("")
    fun addOrder(
        @Body order: Order,
        @Body itemOrder: ArrayList<OrderItem>
    ): Call<Boolean>

    @POST("signUp")
    fun signUp(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("phone") phone: String,
        @Query("address") address: String
    ): Call<ResultLogin>

    @POST("")
    fun forgotPassword(email: String): Call<Int>

    @POST("userInfoById")
    fun getUserInfoByUserID(@Query("userId") userID: Int): Call<ArrayList<User>>

    @GET("allSalePros")
    fun getListProductSale(): Call<ArrayList<Product>>

    @GET("allPros")
    fun getAllProducts(): Call<ArrayList<Product>>

    @GET("allProsOfCate")
    fun getListProductOfCategory(@Query("cateId") cateId: Int): Call<ArrayList<Product>>

    @GET("proDetail")
    fun getProductDetailByID(@Query("proId") productID: Int): Call<ArrayList<Product>>

    @POST("")
    fun addCart(productID: Int, userId: Int): Call<Boolean>

    @GET("")
    fun getListOrder(userId: Int): Call<ArrayList<Product>>

    @GET("allCards")
    fun getListSlider(): Call<ArrayList<Slide>>

    @GET("allCates")
    fun getListCategory(): Call<ArrayList<Category>>

    @GET("cartCount")
    fun getCartCount(@Query("userId")userID: Int): Call<Int>

    @POST("")
    fun minusCart(userID: Int, productID: Int): Call<Boolean>

    @POST("")
    fun plusCart(userID: Int, productID: Int): Call<Boolean>

    @DELETE("deleteCartItem")
    fun delItemCart(@Query("userId")userID: Int,@Query("productId") productID: Int): Call<Boolean>

    @GET("allProsOfCart")
    fun getProductsCart(@Query("userId")userID: Int): Call<ArrayList<ProductCart>>
}