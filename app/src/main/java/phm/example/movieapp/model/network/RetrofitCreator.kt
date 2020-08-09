package phm.example.movieapp.model.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {

    companion object{
        val BASE_URL = "https://ghibliapi.herokuapp.com"

        private fun defaultRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        fun <T> create(service: Class<T>): T{
            return defaultRetrofit().create(service)
        }
    }
}