package pl.edu.pwr.maciejewski.grzegorz.lab2

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.edu.pwr.maciejewski.grzegorz.lab2.FragmentsActivities.MovieDetailsFrag

class MovieDetailsActivity : AppCompatActivity() {
    companion object {
        private val Identification = "IDENT"

        fun makeStartingIntent(context: Context, index: Int): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            return intent.putExtra(Identification, index)
        }
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_movie)
            if (savedInstanceState == null)
                addMovieFragIfEmpty()
        }

        private fun addMovieFragIfEmpty() {
            val innerFragment: Fragment? = fragmentManager.findFragmentById(R.id.upperFragm)
            if (innerFragment == null)
                addMovieFragment()
        }

        private fun addMovieFragment() {
            val index = intent.extras.getInt(Identification)
            val movieFragment = MovieDetailsFrag.newFragment(index)
            val transaction = fragmentManager.beginTransaction()
            with(transaction) {
                add(R.id.outer_container, movieFragment)
                commit()
            }
        }

        override fun onSupportNavigateUp() =
                if (fragmentManager.backStackEntryCount > 0) {
                    fragmentManager.popBackStack()
                    false
                } else
                    super.onSupportNavigateUp()


    }


