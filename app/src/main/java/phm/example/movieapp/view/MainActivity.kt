package phm.example.movieapp.view

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import phm.example.movieapp.R
import phm.example.movieapp.base.BaseActivity
import phm.example.movieapp.model.Movie
import phm.example.movieapp.presenter.MovieContract
import phm.example.movieapp.presenter.MoviePresenter

class MainActivity : BaseActivity(), MovieContract.View {

    private lateinit var moviePrsenter: MoviePresenter
    lateinit var recycler : RecyclerView
    lateinit var mAdapter : MovieAdapter

    override fun initPresenter() {
        moviePrsenter = MoviePresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviePrsenter.takeView(this)
        moviePrsenter.getMovieList()

    }

    override fun onDestroy() {
        moviePrsenter.dropView()
        super.onDestroy()
    }

    override fun showError(error: String) {
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showMovieList(movieList: ArrayList<Movie>) {
        recycler = findViewById(R.id.recycler)
        mAdapter = MovieAdapter(this, movieList)
        moviePrsenter.getMovieList()
        recycler.adapter = mAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
    }
}
