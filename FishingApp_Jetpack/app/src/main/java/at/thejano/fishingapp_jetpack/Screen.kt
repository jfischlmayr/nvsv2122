package at.thejano.fishingapp_jetpack

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Contest: Screen(route = "contest_screen")
}
