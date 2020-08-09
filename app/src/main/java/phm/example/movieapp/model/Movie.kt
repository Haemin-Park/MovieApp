package phm.example.movieapp.model

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("director")
    var director: String? = null
    @SerializedName("producer")
    var producer: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("rt_score")
    var rtScore: String? = null
    @SerializedName("people")
    var people: List<String>? = null
    @SerializedName("species")
    var species: List<String>? = null
    @SerializedName("locations")
    var locations: List<String>? = null
    @SerializedName("vehicles")
    var vehicles: List<String>? = null
    @SerializedName("url")
    var url: String? = null

}