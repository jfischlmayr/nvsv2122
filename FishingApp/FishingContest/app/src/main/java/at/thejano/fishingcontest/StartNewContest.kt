package at.thejano.fishingcontest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar

class StartNewContest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_new_contest)

        val toolbar: Toolbar = findViewById(R.id.toolbarEnterNewContest)
        setSupportActionBar(toolbar)

        val locationSpinner: Spinner = findViewById(R.id.locationSpinner)

        val locationNames = mutableListOf<String>("Teich Marchtrenk", "Donau Ybbs")

        val locationSpinnerAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, locationNames)

        locationSpinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        locationSpinner.adapter = locationSpinnerAdapter

        val buttonCreateLocation: Button = findViewById(R.id.button_redirect_create_location)
        buttonCreateLocation.setOnClickListener{
            startActivity(Intent(this, CreateLocation::class.java))
        }

        val buttonSaveContest: Button = findViewById(R.id.buttonSaveContest)
        buttonSaveContest.setOnClickListener{
            finish()
        }
    }
}