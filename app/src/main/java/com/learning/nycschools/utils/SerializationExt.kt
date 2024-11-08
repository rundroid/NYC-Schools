package com.learning.nycschools.utils

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
val JSON = Json {
    ignoreUnknownKeys = true
    explicitNulls = true
    isLenient = true
    prettyPrint = true
}

inline fun <reified SerializedType : Any> navType(): NavType<SerializedType> {

    return object : NavType<SerializedType>(true) {
        override fun get(bundle: Bundle, key: String): SerializedType? {
            return bundle.getString(key)?.let { parseValue(it) }
        }

        override fun parseValue(value: String): SerializedType {
            return JSON.decodeFromString(value)
        }

        override fun put(bundle: Bundle, key: String, value: SerializedType) {
            bundle.putString(key, JSON.encodeToString(value))
        }
    }
}