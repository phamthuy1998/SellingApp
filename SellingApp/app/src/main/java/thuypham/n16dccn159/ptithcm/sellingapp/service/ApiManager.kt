package thuypham.n16dccn159.ptithcm.sellingapp.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import thuypham.n16dccn159.ptithcm.sellingapp.data.Category
import thuypham.n16dccn159.ptithcm.sellingapp.data.Product
import thuypham.n16dccn159.ptithcm.sellingapp.data.Slide
import thuypham.n16dccn159.ptithcm.sellingapp.data.User

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

    @POST("")
    fun login(email: String, password: String): Call<Int>

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

    @POST("")
    fun addOrder(): Call<ArrayList<Product>>

    @GET("")
    fun getListCategory(): Call<ArrayList<Category>>
}