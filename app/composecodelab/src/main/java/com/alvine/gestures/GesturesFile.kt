package com.alvine.gestures

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvine.composecodelab.R
import com.alvine.navigation.ui.theme.ComposeBasicsTheme


@Composable
fun ImageGestures(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items (images){image->
            ImageContent(photos = image)
        }
    }
    
}

@Composable
fun ImageContent(
    modifier: Modifier = Modifier,
    photos: Photos
) {
    Box (
        modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier
                .height(120.dp)
                .width(180.dp),
            painter = painterResource(id = photos.image),
            contentDescription = "Mountain Images",
            contentScale = ContentScale.Fit
        )
    }
}


data class Photos(
    @DrawableRes val image:Int
)
val images= listOf(
    Photos(
        image = R.drawable.one
    ),
      Photos(
        image = R.drawable.two
    ),
      Photos(
        image = R.drawable.three
    ),
      Photos(
        image = R.drawable.four
    ),
      Photos(
        image = R.drawable.five
    ),
      Photos(
        image = R.drawable.six
    ),
      Photos(
        image = R.drawable.seven
    ),
      Photos(
        image = R.drawable.eight
    ),
      Photos(
        image = R.drawable.nine
    ),
      Photos(
        image = R.drawable.ten
    ),
      Photos(
        image = R.drawable.eleven
    ),
      Photos(
        image = R.drawable.twelve
    ),
      Photos(
        image = R.drawable.thirteen
    ),
      Photos(
        image = R.drawable.fourteen
    ),
      Photos(
        image = R.drawable.fifteen
    ),


)


@Preview
@Composable
private fun HomePreview() {
    ComposeBasicsTheme {
        ImageGestures()
    }
}