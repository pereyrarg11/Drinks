package com.pereyrarg11.drinks.core.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Represents a response body for Api calls.
 */
data class ResponseBodyDto<T>(
    @SerializedName("drinks") val drinks: List<T>?,
)
