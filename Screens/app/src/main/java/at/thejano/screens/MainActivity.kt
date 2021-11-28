package at.thejano.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btnOpenAct2)
        val editField: EditText = findViewById(R.id.edit_message)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra(SecondActivity.EXTRA_DISPLAY_MESSAGE, editField.text.toString());
            }
            startActivity(intent)
        }
    }
}