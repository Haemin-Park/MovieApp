package phm.example.movieapp.model.network

import io.reactivex.Observable
import phm.example.movieapp.model.Image
import phm.example.movieapp.model.network.RetrofitCreator.Companion.IMAGE_BASE_URL
import retrofit2.http.*

class ImageAPI {
    interface ImageImpl{
        @GET("/v1/search/image")
        @Headers(
            "X-Naver-Client-Id: Do9bYJtZV5P35LJl_NTF",
            "X-Naver-Client-Secret: 9FwUPrEuE4" )
        fun getImage(@QueryMap query: MutableMap<String, String?>): Observable<Image>
    }

    companion object{
        fun getImage(query: MutableMap<String, String?>): Observable<Image> {
            return RetrofitCreator.create(IMAGE_BASE_URL,ImageImpl::class.java).getImage(query)
        }
    }
}