package pl.edu.pwr.maciejewski.grzegorz.lab2.FragmentsActivities

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_images.*
import pl.edu.pwr.maciejewski.grzegorz.lab2.R
import pl.edu.pwr.maciejewski.grzegorz.lab2.movieList

/**
 * Created by PanG on 23.05.2017.
 */
class MovieImagesFrag : Fragment() {
    companion object {
        val Identification = "IDENT"

        fun newFragment(index: Int): MovieImagesFrag {
            val movieImage = MovieImagesFrag()
            val containerBundle = Bundle()
            containerBundle.putInt(Identification, index)
            movieImage.arguments = containerBundle
            return movieImage
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_images, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showImages()
    }

    private fun setMovieImages(images: List<Int>) {
        ivStill1.setImageResource(images[0])
        ivStill2.setImageResource(images[1])
        ivStill3.setImageResource(images[2])
        ivStill4.setImageResource(images[0])
        ivStill5.setImageResource(images[1])
        ivStill6.setImageResource(images[2])
    }

    private fun showImages() {
        val imageIndex = arguments.getInt(MovieDetailsFrag.Identification)
        val movie = movieList[imageIndex]
        setMovieImages(movie.images)
    }

}
