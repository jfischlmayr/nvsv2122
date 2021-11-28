package at.thejano.fishingcontest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import at.thejano.fishingcontest.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val buttonCreateContest: Button = findViewById(R.id.buttonCreateNewContest)
        buttonCreateContest.setOnClickListener{
            startActivity(Intent(this, StartNewContest::class.java))
        }

        intent = Intent(this, StartNewContest::class.java)
        startActivity(intent)
    }
}