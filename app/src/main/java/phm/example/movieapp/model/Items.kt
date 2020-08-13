package phm.example.movieapp.model

class Items {
    var thumbnail: String? = null
    var sizeheight: String? = null
    var link: String? = null
    var title: String? = null
    var sizewidth: String? = null

    override fun toString(): String {
        return "ClassPojo [thumbnail = $thumbnail, sizeheight = $sizeheight, link = $link, title = $title, sizewidth = $sizewidth]"
    }
}