package thuypham.n16dccn159.ptithcm.sellingapp.ext

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity


//KEY WORD
//
//class PrefUtil constructor(
//    private val context: Context,
//    private val prefs: SharedPreferences,
//    private val gSon: Gson
//) {
//
////    fun isNetworkConnected(): Boolean {
////        var result = false
////        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
////        cm.getNetworkCapabilities(cm.activeNetwork)?.run {
////            result = when {
////                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
////                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
////                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
////                else -> false
////            }
////        }
////        return result
////    }
//
//    fun clearAllData() = prefs.edit().clear().commit()
//
//    var user: User?
//        get() {
//            return try {
//                gSon.fromJson(
//                    prefs.getString(USER_PROFILE, null),
//                    User::class.java
//                )
//            } catch (e: Exception) {
//                null
//            }
//        }
//        set(value) = prefs.edit().putString(
//            USER_PROFILE,
//            gSon.toJson(value)
//        ).apply()
//}


const val PREFS_NAME = "PREFERENCES"
const val USER_ID = "USER_ID"

fun Context.removeValueSharePrefs(KEY_NAME: String) {
    val pref: SharedPreferences = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = pref.edit()
    editor.remove(KEY_NAME)
    editor.apply()
}

fun Context.getIntPref(valueName: String): Int {
    val pref = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    return pref.getInt(valueName, -1)
}

fun Context.getBooleanPref(valueName: String): Boolean{
    val pref = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    return pref.getBoolean(valueName, false)
}

fun Context.setIntPref(valueName: String, value: Int) {
    val pref: SharedPreferences = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putInt(valueName, value)
    editor.apply()
}


fun Context.getStringPref(valueName: String): String?{
    val pref = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    return pref.getString(valueName,"")
}

fun Context.setStringPref(valueName: String, value: String) {
    val pref: SharedPreferences = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putString(valueName, value)
    editor.apply()
}

fun Context.setBooleanPref(valueName: String, value: Boolean) {
    val pref: SharedPreferences = getSharedPreferences(PREFS_NAME, AppCompatActivity.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putBoolean(valueName, value)
    editor.apply()
}