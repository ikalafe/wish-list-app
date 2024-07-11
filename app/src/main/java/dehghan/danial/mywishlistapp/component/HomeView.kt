package dehghan.danial.mywishlistapp.component

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dehghan.danial.mywishlistapp.R
import dehghan.danial.mywishlistapp.data.DummyWish
import dehghan.danial.mywishlistapp.data.Wish
import dehghan.danial.mywishlistapp.screens.ScreenRoute
import dehghan.danial.mywishlistapp.ui.theme.BackgroundAppBar
import dehghan.danial.mywishlistapp.viewmodel.WishViewModel
import io.eyram.iconsax.IconSax

@Composable
fun HomeView(navController: NavController, viewModel: WishViewModel) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(
                title = stringResource(R.string.wish_app),
                onBackNavClicked = {
                    Toast.makeText(context, "ButtonClicked", Toast.LENGTH_SHORT).show()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(ScreenRoute.AddScreen.route) },
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = BackgroundAppBar,

                ) {
                Icon(
                    painter = painterResource(id = IconSax.Linear.Add),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(DummyWish.wishList) { wish ->
                WishItem(wish = wish) {

                }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClickCard: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        onClick = { onClickCard() },
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = wish.title, color = BackgroundAppBar, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = wish.description, color = Color.Black)
        }
    }
}