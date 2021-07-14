package com.example.kotlincleanarchitecture.data

import androidx.viewbinding.BuildConfig
import okhttp3.HttpUrl

class URLFactory {
    private val SCHEME = "https"
    private val URL_PROD = "reqres.in"
    private val URL_TESTING = "reqres.in"

    operator fun invoke(): HttpUrl {

        return HttpUrl.Builder()
            .apply {
                when (BuildConfig.BUILD_TYPE) {
                    "release" -> {
                        host(URL_PROD)
                        scheme(SCHEME)
                        addPathSegments("api/v1/")
                    }
                    else -> {
                        host(URL_TESTING)
                        scheme(SCHEME)
                        addPathSegments("api/v1/")
                    }
                }
            }
            .build()
    }
}