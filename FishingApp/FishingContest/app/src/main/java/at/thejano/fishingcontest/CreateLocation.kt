package at.thejano.fishingcontest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class CreateLocation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_location)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val editName: EditText = findViewById(R.id.locationNameInput)
        val editLocation: EditText = findViewById(R.id.locationPostalAddressInput)
        val editNumberOfPlaces: EditText = findViewById(R.id.numberOfPlaces)
        val editButtonCreateLocation: Button = findViewById(R.id.button_create_location)
    }
}