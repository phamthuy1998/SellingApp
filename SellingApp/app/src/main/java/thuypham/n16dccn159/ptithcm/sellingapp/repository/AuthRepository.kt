package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.Result
import thuypham.n16dccn159.ptithcm.sellingapp.data.ResultLogin
import thuypham.n16dccn159.ptithcm.sellingapp.data.User

interface AuthRepository {
    fun login(email: String, password: String): Result<ResultLogin>
    fun signUp(
        username: String,
        password: String,
        name: String,
        email: String,
        phone: String,
        address: String ): Result<ResultLogin>

    fun forgotPassword(email: String): Result<Int>
    fun getUserInfoByUserID(userID: Int): Result<User>
}