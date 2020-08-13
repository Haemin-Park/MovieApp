package phm.example.movieapp.model


class Image {
    var total: String? = null
    var lastBuildDate: String? = null
    var display: String? = null
    var start: String? = null
    var items: ArrayList<Items>?=null

    override fun toString(): String {
        return "ClassPojo [total = $total, lastBuildDate = $lastBuildDate, display = $display, start = $start, items = $items]"
    }

}