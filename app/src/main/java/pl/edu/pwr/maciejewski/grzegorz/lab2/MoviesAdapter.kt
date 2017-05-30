package pl.edu.pwr.maciejewski.grzegorz.lab2


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup

class MoviesAdapter(private val moviesList: List<Movie>, private val listener: OnItemClickListener, private val onItemLongClickListener: OnItemLongClickListener) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_list_row, parent, false)

        return MovieViewHolder(itemView,listener,onItemLongClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre.name.toLowerCase()
        holder.year.text = movie.year
        holder.movieImage.setImageResource(movie.genre.imageResource)
        holder.seenEye.visibility=
                if (!movie.seen)
                    INVISIBLE
                else
                    VISIBLE
    }



    override fun getItemCount(): Int {
        return moviesList.size
    }


}