package pl.edu.pwr.maciejewski.grzegorz.lab2


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), OnItemClickListener, OnItemLongClickListener {
    //private val movieList = ArrayList<Movie>()
    private val adapter: MoviesAdapter by lazy { MoviesAdapter(movieList, this,this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        PrepareRecyclerView()
        swipe.attachToRecyclerView(recyclerView)


    }

    private fun PrepareRecyclerView(){
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            recyclerView.itemAnimator = DefaultItemAnimator()
    }



    val swipe= ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?) = false
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteItem(viewHolder)
        }
    })

    private fun deleteItem(viewHolder: RecyclerView.ViewHolder){
        val position=viewHolder.adapterPosition
        movieList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    override fun onItemClick(position: Int) {
        val intent = MovieDetailsActivity.makeStartingIntent(this, position)
        startActivity(intent)
    }

    /*override fun onItemClick(position:Int){
        val movie =movieList[position]
        val intent= MovieDetailsActivity.getStartingIntent(
                this, movie.title, movie.genre.imageResource, movie.description)
        startActivity(intent)
    }*/

    override fun onItemLongClick(position: Int): Boolean {
        val movie=movieList[position]
        movie.seen = !movie.seen
        adapter.notifyDataSetChanged()
        return true;
    }


}

val movieList = arrayListOf(
        Movie("Mad Max: Fury Road", MovieGenre.ACTION, "2015"),
        Movie("Inside Out", MovieGenre.ADVENTURE, "2015"),
        Movie("Star Wars: Episode VII - The Force Awakens", MovieGenre.ACTION, "2015"),
        Movie("Shaun the Sheep", MovieGenre.ADVENTURE, "2015"),
        Movie("The Martian", MovieGenre.FANTASY, "2015"),
        Movie("Mission: Impossible Rogue Nation", MovieGenre.ACTION, "2015"),
        Movie("Up", MovieGenre.ADVENTURE, "2009"),
        Movie("Star Trek", MovieGenre.FANTASY, "2009"),
        Movie("The LEGO Movie", MovieGenre.ADVENTURE, "2014"),
        Movie("Iron Man", MovieGenre.ACTION, "2008"),
        Movie("Aliens", MovieGenre.FANTASY, "1986"),
        Movie("Chicken Run", MovieGenre.ADVENTURE, "2000"),
        Movie("Back to the Future", MovieGenre.FANTASY, "1985"),
        Movie("Raiders of the Lost Ark", MovieGenre.ACTION, "1981"),
        Movie("Goldfinger", MovieGenre.ACTION, "1965"),
        Movie("Guardians of the Galaxy", MovieGenre.FANTASY, "2014")
)
