package com.alvine.gestures

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alvine.composecodelab.R


@Composable
fun App(
    photos:List<Photos>
) {
    var activeId by rememberSaveable {
        mutableStateOf<Int?>(null)
    }
    PhotoGrid(photos = photos)
    if (activeId!=null){
        FullScreenPhoto(
            photo= photos.first{it.id==activeId},
            onDismiss={activeId=null }
        )
    }
}

@Composable
fun FullScreenPhoto(
    photo: Photos,
    onDismiss: () -> Unit,
    modifier: Modifier=Modifier
) {
    Box (
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        //Scrim()
        PhotoImage(photo)
    }

}

@Composable
private fun PhotoImage(
    photo: Photos,
    modifier: Modifier=Modifier,

) {
  Image(
      painter = rememberAsyncImagePainter(photo.highResUrl),
      contentDescription ="",
      modifier= modifier
          .clipToBounds()
          .pointerInput(Unit){
              detectTapGestures(onDoubleTap = {tapOffset->
                  zoom= if (zoom > 1f) 1f else 2f
                  offset= calculateDoubleTapOffset(zoom, size,tapOffset)

              })
          }
          .graphicsLayer {
              translationX= -offset.x*zoom
              translationY-offset.y*zoom
              scaleX= zoom; scaleY=zoom
              transformOrigin= TransformOrigin(0f,0f)
          } )
}


@Composable
private fun PhotoGrid(
    photos:List<Photos>,
    navigateToPhoto:(Int) ->Unit={}
) {
    LazyVerticalGrid(GridCells.Adaptive(128.dp)) {
        items(photos, key = {it.id!!}){photo->
            PhotoItem(

data class Photos(
    val id:Int?=null,
    @DrawableRes val image:Int
) {
    val highResUrl: Any?
        get() {
            TODO()
        }
}

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


