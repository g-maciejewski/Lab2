package pl.edu.pwr.maciejewski.grzegorz.lab2.FragmentsActivities

/**
 * Created by PanG on 23.05.2017.
 */

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_actors.*
import pl.edu.pwr.maciejewski.grzegorz.lab2.Actor
import pl.edu.pwr.maciejewski.grzegorz.lab2.R
import pl.edu.pwr.maciejewski.grzegorz.lab2.movieList

class ActorsFragm : android.app.Fragment() {
    companion object {
        val Identification = "IDENT"

        fun newFragment(index: Int): ActorsFragm {
            val actorsFragm = ActorsFragm()
            val containerBundle = Bundle()
            containerBundle.putInt(Identification, index)
            actorsFragm.arguments = containerBundle
            return actorsFragm
        }
    }

    override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? =
            inflater.inflate(R.layout.fragment_actors, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showActors()
    }

    private fun showActors() {
        val index = arguments.getInt(MovieDetailsFrag.Identification)
        val movie = movieList[index]
        set(tvActor1, ivActor1, movie.actors[0])
        set(tvActor2, ivActor2, movie.actors[1])
        set(tvActor3, ivActor3, movie.actors[0])
    }

    private fun set(textView: TextView, imageView: ImageView, actor: Actor) {
        textView.text = actor.actorName
        imageView.setImageResource(actor.picture)
    }


}
