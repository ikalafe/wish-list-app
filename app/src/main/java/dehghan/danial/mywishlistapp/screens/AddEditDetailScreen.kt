package dehghan.danial.mywishlistapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dehghan.danial.mywishlistapp.R
import dehghan.danial.mywishlistapp.component.AppBarView
import dehghan.danial.mywishlistapp.ui.theme.BackgroundAppBar
import dehghan.danial.mywishlistapp.ui.theme.ColorLabelOutTxtField
import dehghan.danial.mywishlistapp.viewmodel.WishViewModel

@Composable
fun AddEdtDetailScreen(id: Long, viewModel: WishViewModel, navController: NavController) {
    Scaffold(topBar = {
        AppBarView(
            title = if (id != 0L) stringResource(R.string.edit_wish) else stringResource(R.string.add_wish),
            onBackNavClicked = { navController.navigateUp() })
    }) {
        Spacer(modifier = Modifier.padding(it))
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 70.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Column(modifier = Modifier.weight(1f)) {// Title Text Field
                WishTextField(
                    label = stringResource(id = R.string.title_outlined_text_field),
                    value = viewModel.wishTitleState
                ) { newString ->
                    viewModel.onWishTitleChanged(newString)
                }
                Spacer(modifier = Modifier.height(5.dp))
                // Description Text Field
                WishTextField(
                    label = stringResource(id = R.string.description_outlined_text_field),
                    value = viewModel.wishDescriptionState
                ) { newString ->
                    viewModel.onWishDescriptionChanged(newString)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Button Save & Update
            Button(
                onClick = {
                    if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                        //TODO: UPDATE

                    } else {
                        //TODO: ADD
                    }
                },
                colors = ButtonDefaults.buttonColors(BackgroundAppBar),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
                    .height(60.dp)
            ) {
                Text(
                    text = if ((id != 0L)) stringResource(id = R.string.update_wish) else stringResource(
                        id = R.string.save_wish
                    ),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(70.dp))


        }
    }
}

@Composable
fun WishTextField(label: String, value: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BackgroundAppBar,
            unfocusedTextColor = ColorLabelOutTxtField,
            focusedLabelColor = BackgroundAppBar,
            unfocusedLabelColor = ColorLabelOutTxtField
        )
    )
}

