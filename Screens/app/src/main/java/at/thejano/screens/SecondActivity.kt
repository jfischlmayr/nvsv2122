package at.thejano.screens

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    // Used to identify shared data using extras when creating this activity
    companion object {
        @JvmStatic
        val EXTRA_DISPLAY_MESSAGE = "SecondActivity.DisplayMessage";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val sharedText = intent.getStringExtra(EXTRA_DISPLAY_MESSAGE);
        val textView: TextView = findViewById<TextView>(R.id.shared_text).apply {
            // Set the shared text into the text view
            text = sharedText
        }

        val button: Button = findViewById(R.id.button_return)
        button.setOnClickListener {
            finish()
        }
    }
}