package at.thejano.moviedatabase.rest

import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.Serializable

interface RestClient {
    @Headers(
        "x-rapidapi-key: db06e44dd5mshfc12a600846056ep1e900fjsne3db9dccf7cb",
        "x-rapidapi-host: imdb8.p.rapidapi.com"
    )
    @GET("title/find")
    fun getMovies(
        @Query("q") q: String
    ): Call<List<Movie>>

    companion object {
        fun create(): RestClient {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://imdb8.p.rapidapi.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(RestClient::class.java)
        }
    }
}

data class Movie(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "runningTimeInMinutes") val runningTimeInMinutes: String?,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "titleType") val titleType: String,
    @field:Json(name = "year") val year: String
) : Serializable