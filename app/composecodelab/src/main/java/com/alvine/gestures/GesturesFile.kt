package com.alvine.gestures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alvine.composecodelab.R


@Composable
fun App(
    photos:List<Photo>
) {
    var activeId by rememberSaveable {
        mutableStateOf<Int?>(null)
    }
    val gridState= rememberLazyGridState()
    var autoScrollSpeed by remember {
        mutableStateOf(0f)
    }
    val scrim= remember(activeId){FocusRequester()}

    PhotoGrid(
        photos = photos,
        state = gridState,
        setAutoScrolledSpeed = { autoScrollSpeed = it },
        navigateToPhoto={activeId=it},
        modifier=Modifier.focusProperties { canFocus=activeId == nulll }
    )
    if (activeId!=null){
        FullScreenPhoto(
            photo= photos.first{it.id==activeId},
            onDismiss={activeId=null }
        )
    }
}

@Composable
private fun FullScreenPhoto(
    photo: Photo,
    onDismiss: () -> Unit,
    modifier: Modifier=Modifier
) {
    Box (
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Scrim(onDismiss)
        PhotoImage(photo)
    }

}

@Composable
private fun Scrim(
    modifier: Modifier=Modifier,
    onClose:() -> Unit
) {
    Box (
        modifier
            .fillMaxSize()
            .background(Color.DarkGray.copy(alpha = 0.75f))
            .pointerInput(onClose()) {
                detectTapGestures { onClose() }
            }
    ){

    }
}

@Composable
private fun PhotoImage(
    photo: Photo,
    modifier: Modifier=Modifier,

)  {
    var offset by remember { mutableStateOf(Offset.Zero) }
    var zoom by remember { mutableStateOf(1f) }
  Image(
      painter = rememberAsyncImagePainter(photo.highResUrl),
      contentDescription ="",
      modifier= modifier
          .clipToBounds()
          .pointerInput(Unit) {
              detectTapGestures(onDoubleTap = { tapOffset ->
                  zoom = if (zoom > 1f) 1f else 2f
                  offset = calculateDoubleTapOffset(zoom, size, tapOffset)

              })
          }
          .pointerInput(Unit) {
              detectTransformGestures { centroid, pan, zoom, gestureZoom ->
                  offset = offset.calculateNewOffset(
                      centroid, pan, zoom, gestureZoom, size
                  )
                  zoom = maxOf(1f, zoom * gestureZoom)
              }
          }
          .graphicsLayer {
              translationX = -offset.x * zoom
              translationY - offset.y * zoom
              scaleX = zoom; scaleY = zoom
              transformOrigin = TransformOrigin(0f, 0f)
          }
          .aspectRatio(1f)

  )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PhotoGrid(
    photos:List<Photo>,
    navigateToPhoto:(Int) ->Unit={}
) {
    var selectedIds by rememberSaveable {
        mutableStateOf(emptyList<Int>())
    }
    val inSelectionMode by remember {
        derivedStateOf { selectedIds.isNotEmpty() }
    }
    LazyVerticalGrid(GridCells.Adaptive(128.dp)) {
        items(photos, key = {it.id!!}){photo->

            val selected by remember {
                derivedStateOf { photo.id in selectedIds }
            }

            PhotoItem(
                selected,inSelectionMode,
                Modifier.combinedClickable(
                    onClick = {navigateToPhoto(photo.id)},
                    onLongClick = {selectedIds +=photo.id}
                )
            )
        }
    }
}

@Composable
fun PhotoItem(selected: Boolean, inSelectionMode: Boolean, combinedClickable: Modifier) {
    if (inSelectionMode){
        if (selected){
            Icons.Filled.CheckCircle
        }else{
            Image(
                painter = painterResource(
                     id = R.drawable.baseline_radio_button_unchecked_24),
                contentDescription = ""
            )
        }
    }

}

class Photo(
    val id: Int,
    val url:String,
    val highResUrl:String,
    val description:String
)

//
//data class Photos(
//    val id:Int?=null,
//    @DrawableRes val image:Int
//)
//
//val images= listOf(
//    Photos(
//        image = R.drawable.one
//    ),
//      Photos(
//        image = R.drawable.two
//    ),
//      Photos(
//        image = R.drawable.three
//    ),
//      Photos(
//        image = R.drawable.four
//    ),
//      Photos(
//        image = R.drawable.five
//    ),
//      Photos(
//        image = R.drawable.six
//    ),
//      Photos(
//        image = R.drawable.seven
//    ),
//      Photos(
//        image = R.drawable.eight
//    ),
//      Photos(
//        image = R.drawable.nine
//    ),
//      Photos(
//        image = R.drawable.ten
//    ),
//      Photos(
//        image = R.drawable.eleven
//    ),
//      Photos(
//        image = R.drawable.twelve
//    ),
//      Photos(
//        image = R.drawable.thirteen
//    ),
//      Photos(
//        image = R.drawable.fourteen
//    ),
//      Photos(
//        image = R.drawable.fifteen
//    ),
//    Photos(
//        image = R.drawable.five
//    ),
//    Photos(
//        image = R.drawable.six
//    ),
//    Photos(
//        image = R.drawable.seven
//    ),
//    Photos(
//        image = R.drawable.eight
//    ),
//    Photos(
//        image = R.drawable.nine
//    ),
//    Photos(
//        image = R.drawable.ten
//    ),
//    Photos(
//        image = R.drawable.eleven
//    ),
//    Photos(
//        image = R.drawable.twelve
//    ),
//    Photos(
//        image = R.drawable.thirteen
//    ),
//    Photos(
//        image = R.drawable.fourteen
//    ),
//    Photos(
//        image = R.drawable.fifteen
//    ),)





