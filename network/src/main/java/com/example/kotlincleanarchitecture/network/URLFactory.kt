package com.example.kotlincleanarchitecture.network

import okhttp3.HttpUrl

class URLFactory {
    companion object {
        private const val SCHEME = "https"
        private const val URL_PROD = "reqres.in"
        private const val URL_TESTING = "reqres.in"
    }

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