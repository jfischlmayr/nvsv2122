package at.thejano.fishingapp_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import at.thejano.fishingapp_jetpack.ui.theme.FishingApp_JetpackTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FishingApp_JetpackTheme {
                navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}