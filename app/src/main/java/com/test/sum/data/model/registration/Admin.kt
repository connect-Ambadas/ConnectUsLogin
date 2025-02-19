package com.test.sum.data.model.registration

data class Admin(
    var adminId: String = "",
    var adminName: String = "",
    var adminCode: String = "",
    var adminLastName: String = "",
    var adminEmailId: String = "",
    var adminPassword: String = "",
    var adminPhoneNumber: String = "",
    var adminShopName: String = "",
    var adminShopAddress: String = "",
    var role: String = "",
    var merchantCode: String = ""
) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "adminId" to adminId,
            "adminName" to adminName,
            "adminCode" to adminCode,
            "adminLastName" to adminLastName,
            "adminEmailId" to adminEmailId,
            "adminPassword" to adminPassword,
            "adminPhoneNumber" to adminPhoneNumber,
            "adminShopName" to adminShopName,
            "adminShopAddress" to adminShopAddress,
            "role" to role,
            "merchantCode" to merchantCode
        ).filterValues { it != null } // Removes null values if any
    }
}
