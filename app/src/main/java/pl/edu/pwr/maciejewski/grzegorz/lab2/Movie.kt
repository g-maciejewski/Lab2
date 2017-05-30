package pl.edu.pwr.maciejewski.grzegorz.lab2

/**
 * Created by PanG on 11.04.2017.
 */

class Movie(val title: String, val genre: MovieGenre, val year: String, val description: String = descriptionOfMovie, var seen: Boolean = false) {

    val actors = actorImages
    val descriptionResource = descriptionOfMovie
    val images = imagesFromMovie
    val mainImg = genre.imageResource


}


val actorImages = listOf(
        Actor("Elvis Presley", R.drawable.elvis),
        Actor("Freddie Mercury", R.drawable.fredi)
)

val imagesFromMovie = listOf(
        R.drawable.movie1,
        R.drawable.movie2,
        R.drawable.movie3
)

val descriptionOfMovie = "description description description description description description description description description"

