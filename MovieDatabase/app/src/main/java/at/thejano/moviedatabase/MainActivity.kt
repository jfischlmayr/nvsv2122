package at.thejano.moviedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import at.thejano.moviedatabase.rest.Movie
import at.thejano.moviedatabase.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.buttonDetail)
        val editField: EditText = findViewById(R.id.editTitle)

        val client = RestClient.create()

        var movies: List<Movie> = listOf()

        val titleSpinner: Spinner = findViewById(R.id.titleSpinner)
        val titleSpinnerAdapter = ArrayAdapter<Movie>(this,
            R.layout.support_simple_spinner_dropdown_item, movies)

        val buttonRequest: Button = findViewById(R.id.buttonRequest)
        buttonRequest.setOnClickListener {
            val apiInterface = client.getMovies(editField.text.toString())
            apiInterface.enqueue(object : Callback<List<Movie>> {
                override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {
                    if(response?.body() != null)
                        movies = response.body()!!
                }

                override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                    println(t?.message)
                }
            })

            //println(movies[0].title)

            titleSpinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            titleSpinner.adapter = titleSpinnerAdapter
        }



        /*val textView: TextView = findViewById<TextView>(R.id.textTest).apply {
            text = movies[0].title
        }*/

        button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, editField.text.toString());
            }
            startActivity(intent)
        }


    }
}