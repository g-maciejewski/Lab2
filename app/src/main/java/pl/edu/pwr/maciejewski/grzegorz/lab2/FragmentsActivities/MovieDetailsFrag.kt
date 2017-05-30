package pl.edu.pwr.maciejewski.grzegorz.lab2.FragmentsActivities

/**
 * Created by PanG on 23.05.2017.
 */
import android.app.Fragment
import android.app.FragmentTransaction
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie.*
import pl.edu.pwr.maciejewski.grzegorz.lab2.R
import pl.edu.pwr.maciejewski.grzegorz.lab2.movieList


class MovieDetailsFrag : Fragment() {
    companion object {
        val Identification = "IDENT"

        fun newFragment(index: Int): MovieDetailsFrag {
            val movieDetalis = MovieDetailsFrag()
            val containerBundle = Bundle()
            containerBundle.putInt(Identification, index)
            movieDetalis.arguments = containerBundle
            return movieDetalis
        }
    }

    val data: SharedPreferences by lazy { activity.getPreferences(Context.MODE_PRIVATE) }
    val index: Int by lazy { arguments.getInt(Identification) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showInfo()
        readSavedData()
        ratingBar.setOnRatingBarChangeListener { _, rating, _ -> saveData(rating) }
        btnInfo.setOnClickListener { runInfoFragmentsMovie() }
    }

    private fun showInfo() {
        val movie = movieList[index]
        tvTitle.text = movie.title
        ivMovieImage.setImageResource(movie.mainImg)
        tvDescription.text = movie.descriptionResource
    }

    private fun readSavedData() {
        ratingBar.rating = data.getFloat(tvTitle.text.toString(), 0f)
    }

    private fun saveData(rating: Float) {
        val editor = data.edit()
        with(editor) {
            putFloat(tvTitle.text.toString(), rating)
            apply()
        }
    }

    private fun runInfoFragmentsMovie() {
        val outerFragment = fragmentManager.findFragmentById(R.id.outer_container)
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            detach(outerFragment)
            add(R.id.upperFragm, MovieImagesFrag.newFragment(index))
            add(R.id.lowerFragm, ActorsFragm.newFragment(index))
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            addToBackStack(null)
            commit()
        }
    }


}


