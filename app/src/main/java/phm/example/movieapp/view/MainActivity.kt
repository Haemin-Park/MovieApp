package phm.example.movieapp.view

import android.os.Bundle
import android.widget.Toast
import phm.example.movieapp.R
import phm.example.movieapp.base.BaseActivity
import phm.example.movieapp.presenter.MovieContract
import phm.example.movieapp.presenter.MoviePresenter

class MainActivity : BaseActivity(), MovieContract.View {

    private lateinit var moviePrsenter: MoviePresenter

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

    override fun showMovieList() {

    }
}
