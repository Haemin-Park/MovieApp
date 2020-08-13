package phm.example.movieapp.model.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {

    companion object{
        val MOVIE_BASE_URL = "https://ghibliapi.herokuapp.com"
        val IMAGE_BASE_URL = "https://openapi.naver.com"

        private fun defaultRetrofit(BASE_URL:String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        fun <T> create(BASE_URL:String, service: Class<T>): T{
            return defaultRetrofit(BASE_URL).create(service)
        }
    }
}