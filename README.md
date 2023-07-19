# sAPI-kotlin
Kotlin библиотека для использования API для продавцов аукциона Мешок

```kotlin
fun main() {
    val token = "your_token_here"
    val meshokAPI = MeshokAPI(token)

    // Get item list
    val itemListResponse = meshokAPI.getItemList()
    println(itemListResponse)

    // Get account info
    val accountInfoResponse = meshokAPI.getAccountInfo()
    println(accountInfoResponse)

    // Get item info
    val itemId = "your_item_id_here"
    val itemInfoResponse = meshokAPI.getItemInfo(itemId)
    println(itemInfoResponse)

    // List an item
    val params = mapOf(
        "name" to "New Item",
        // Add other required parameters
    )
    val listItemResponse = meshokAPI.listItem(params)
    println(listItemResponse)

    // Update an item
    val updateParams = mapOf(
        "id" to itemId,
        "name" to "Updated Item",
        // Add other parameters to update
    )
    val updateItemResponse = meshokAPI.updateItem(updateParams)
    println(updateItemResponse)

    // Delete an item
    val deleteItemResponse = meshokAPI.deleteItem(itemId)
    println(deleteItemResponse)
}
```

Make sure to replace `"your_token_here"` with your actual Meshok API token and `"your_item_id_here"` with the ID of the item you want to perform operations on.
