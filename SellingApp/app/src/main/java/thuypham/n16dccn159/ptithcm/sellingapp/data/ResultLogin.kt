package thuypham.n16dccn159.ptithcm.sellingapp.data

class ResultLogin : ArrayList<ResultLoginItem>()

data class ResultLoginItem(
    val message: String,
    val result: Int
)