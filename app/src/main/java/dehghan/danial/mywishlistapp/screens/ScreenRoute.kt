package dehghan.danial.mywishlistapp.screens

sealed class ScreenRoute(val route: String) {
    data object HomeScreen : ScreenRoute("home_screen")
    data object AddScreen : ScreenRoute("add_screen")

}