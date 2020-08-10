package phm.example.movieapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import phm.example.movieapp.R
import phm.example.movieapp.model.Movie

class MovieAdapter(val context: Context, val movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.Holder>(){

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(movieList[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return Holder(view)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val movieTitle = itemView.findViewById<TextView>(R.id.title)

        fun bind(movie: Movie, context: Context){

            movieTitle?.text= movie.title

        }
    }

}