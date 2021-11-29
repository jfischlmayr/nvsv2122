package at.thejano.moviedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        val EXTRA_TITLE = "SecondActivity.DisplayMessage";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //val toolbar: Toolbar = findViewById(R.id.toolbarDetail)
        //setSupportActionBar(toolbar)

        val sharedTitle = intent.getStringExtra(EXTRA_TITLE);
        val textView: TextView = findViewById<TextView>(R.id.shared_title).apply {
            text = sharedTitle
        }

        val button: Button = findViewById(R.id.buttonDetailBack)
        button.setOnClickListener {
            finish()
        }
    }
}