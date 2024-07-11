package dehghan.danial.mywishlistapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dehghan.danial.mywishlistapp.component.HomeView
import dehghan.danial.mywishlistapp.screens.AddEdtDetailScreen
import dehghan.danial.mywishlistapp.screens.ScreenRoute
import dehghan.danial.mywishlistapp.viewmodel.WishViewModel

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = ScreenRoute.HomeScreen.route) {
        composable(route = ScreenRoute.HomeScreen.route) {
            HomeView(navController = navController,viewModel = viewModel)
        }
        composable(route = ScreenRoute.AddScreen.route) {
            AddEdtDetailScreen(id = 0L, viewModel = viewModel, navController = navController)
        }
    }
}