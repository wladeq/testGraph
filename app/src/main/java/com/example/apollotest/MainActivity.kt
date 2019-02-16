package com.example.apollotest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException

class MainActivity : AppCompatActivity() {
    private var uiHandler = Handler(Looper.getMainLooper())
    val dataCallback = ApolloCallback(object : ApolloCall.Callback<TestQuery.Data>() {
        override fun onResponse(response: Response<TestQuery.Data>) {
            print(response.data())
        }

        override fun onFailure(e: ApolloException) {
            print("Nie norm - ")
        }
    }, uiHandler)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getIds()
    }

    fun getIds() {

        MyApolloClient().getMyApolloClient().query(
                TestQuery.builder().build()).enqueue(dataCallback)
    }

}
