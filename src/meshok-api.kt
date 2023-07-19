import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MeshokAPI(private val token: String) {
    private val baseUrl = "https://api.meshok.net/sAPIv1/"

    private fun sendRequest(method: String, params: Map<String, String> = emptyMap()): JSONObject {
        val url = baseUrl + method
        val headers = mapOf("Authorization" to "Bearer $token")
        val requestBody = FormBody.Builder().apply {
            params.forEach { (key, value) -> add(key, value) }
        }.build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .headers(Headers.of(headers))
            .build()

        val client = OkHttpClient()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body?.string()
            return JSONObject(responseBody)
        }
    }

    fun getItemList(): JSONObject {
        return sendRequest("getItemList")
    }

    fun getFinishedItemList(): JSONObject {
        return sendRequest("getFinishedItemList")
    }

    fun getUnsoldFinishedItemList(): JSONObject {
        return sendRequest("getUnsoldFinishedItemList")
    }

    fun getSoldFinishedItemList(): JSONObject {
        return sendRequest("getSoldFinishedItemList")
    }

    fun getItemInfo(id: String): JSONObject {
        return sendRequest("getItemInfo", mapOf("id" to id))
    }

    fun getAccountInfo(): JSONObject {
        return sendRequest("getAccountInfo")
    }

    fun getCommonDescriptionList(): JSONObject {
        return sendRequest("getCommonDescriptionList")
    }

    fun getSubCategory(id: String): JSONObject {
        return sendRequest("getSubCategory", mapOf("id" to id))
    }

    fun getCategoryInfo(id: String): JSONObject {
        return sendRequest("getCategoryInfo", mapOf("id" to id))
    }

    fun getCurencyList(): JSONObject {
        return sendRequest("getCurencyList")
    }

    fun getCountryList(): JSONObject {
        return sendRequest("getCountryList")
    }

    fun getCitiesList(id: String): JSONObject {
        return sendRequest("getCitiesList", mapOf("id" to id))
    }

    fun stopSale(id: String): JSONObject {
        return sendRequest("stopSale", mapOf("id" to id))
    }

    fun relistItem(id: String): JSONObject {
        return sendRequest("relistItem", mapOf("id" to id))
    }

    fun deleteItem(id: String): JSONObject {
        return sendRequest("deleteItem", mapOf("id" to id))
    }

    fun listItem(params: Map<String, String>): JSONObject {
        return sendRequest("listItem", params)
    }

    fun updateItem(params: Map<String, String>): JSONObject {
        return sendRequest("updateItem", params)
    }
}
