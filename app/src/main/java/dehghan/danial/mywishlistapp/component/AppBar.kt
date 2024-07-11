package dehghan.danial.mywishlistapp.component

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dehghan.danial.mywishlistapp.ui.theme.BackgroundAppBar
import io.eyram.iconsax.IconSax

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(title: String, onBackNavClicked: () -> Unit = {}) {

    val navigationButton: (@Composable () -> Unit)? = {
        if (!title.contains("WISH APP")) {
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(
                    painter = painterResource(id = IconSax.Bold.ArrowLeft2),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        } else {
            null
        }
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp),
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(BackgroundAppBar),
        navigationIcon = navigationButton!!
    )
}