package at.thejano.saveandrestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve components from view
        val button: Button = findViewById(R.id.button_first);
        val editField: EditText = findViewById(R.id.edit_message)

        button.setOnClickListener {
            // Create a new intent and supply the value of the edit field
            // as string to the second activity using extras
            val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra(SecondActivity.EXTRA_DISPLAY_MESSAGE, editField.text.toString());
            }
            startActivity(intent);
        };
    }
}