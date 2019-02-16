package com.example.apollotest

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class MyApolloClient {
    private val BASE_URL: String = "https://eu1.prisma.sh/jaroslavi-b7c2e1/apollo/dev"
    private lateinit var myApolloCleint: ApolloClient

    internal fun getMyApolloClient(): ApolloClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        var okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        myApolloCleint = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build()

        return myApolloCleint
    }

}