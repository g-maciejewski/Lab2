package pl.edu.pwr.maciejewski.grzegorz.lab2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.movie_list_row.view.*

/**
 * Created by PanG on 07.05.2017.
 */
class MovieViewHolder(view: View, listener: OnItemClickListener, longClickListener: OnItemLongClickListener) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.title
    val year: TextView = view.year
    val genre: TextView = view.genre
    val movieImage: ImageView = view.movieImage
    val seenEye: ImageView = view.ivSeen

    init {
        view.setOnClickListener { listener.onItemClick(adapterPosition) }
       view.setOnLongClickListener {longClickListener.onItemLongClick(adapterPosition)}
        }

}