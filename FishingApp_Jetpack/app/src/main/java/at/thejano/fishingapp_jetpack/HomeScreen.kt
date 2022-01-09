package at.thejano.fishingapp_jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun HomeScreen(navController: NavController) {
    val constraints = ConstraintSet {
        val buttonAddContest = createRefFor("buttonAddContest")

        constrain(buttonAddContest){
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 10.dp)
        }
    }
    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize().background(Color.Red)) {

        var tabIndex by remember { mutableStateOf(0) }
        val tabTitles = listOf("Contests", "Leaderboard")
        val pagerState = rememberPagerState()
        Column {
            TabRow(selectedTabIndex = tabIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(
                            pagerState,
                            tabPositions
                        )
                    )
                }) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(text = title) })
                }
            }
            HorizontalPager(
                count = tabTitles.size,
                state = pagerState,
            ) { tabIndex ->
                if (tabIndex == 0) {
                    Text(
                        text = "You haven't created contests yet!",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    )
                } else if (tabIndex == 1) {
                    Text(
                        text = "There are no players to display!",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    )
                }
            }
        }
        Box(modifier = Modifier.wrapContentSize().layoutId("buttonAddContest")) {
            Button(onClick = { navController.navigate(route = Screen.Contest.route) }) {
                Text("Add Contest")
            }
        }
    }
}
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}