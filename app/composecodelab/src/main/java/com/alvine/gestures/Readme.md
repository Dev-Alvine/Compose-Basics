# Photo Gallery App Documentation

## Overview
This Kotlin code implements a photo gallery application using Jetpack Compose. The app features a grid view of photos, selection functionality, full-screen photo view, and zooming capabilities.

## Main Components

### 1. App Composable
The main composable function that sets up the overall structure of the app.

```kotlin
@Composable
fun App(photos: List<Photo>) {
}
```

#### Key Features:
- Manages the state for the active (full-screen) photo
- Handles auto-scrolling of the photo grid
- Switches between grid view and full-screen view

### 2. PhotoGrid Composable
Displays a grid of photos with selection capabilities.

```kotlin
@Composable
private fun PhotoGrid(
    photos: List<Photo>,
    state: LazyGridState,
    modifier: Modifier = Modifier,
    setAutoScrollSpeed: (Float) -> Unit = { },
    navigateToPhoto: (Int) -> Unit = { }
) {
}
```

#### Key Features:
- Uses `LazyVerticalGrid` for efficient photo display
- Implements selection mode with long-press gesture
- Handles item clicks for navigation to full-screen view

### 3. PhotoItem Composable
Represents an individual photo in the grid.

```kotlin
@Composable
private fun PhotoItem(
    photo: Photo,
    inSelectionMode: Boolean,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
}
```

#### Key Features:
- Displays the photo image
- Shows selection state with animations
- Adapts UI based on selection mode

### 4. FullScreenPhoto Composable
Displays a photo in full-screen mode with zooming capabilities.

```kotlin
@Composable
private fun FullScreenPhoto(
    photo: Photo,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
}
```

#### Key Features:
- Shows the photo in full screen
- Implements a dismissible scrim (background)
- Utilizes `PhotoImage` for zoom functionality

### 5. PhotoImage Composable
Handles the display and interaction of a single photo, including zoom and pan.

```kotlin
@Composable
fun PhotoImage(photo: Photo, modifier: Modifier = Modifier) {
}
```

#### Key Features:
- Implements double-tap to zoom
- Supports pinch-to-zoom and pan gestures
- Constrains image movement within bounds

## Custom Modifiers and Extensions

### photoGridDragHandler
A custom modifier that handles drag gestures for multi-select in the photo grid.

```kotlin
fun Modifier.photoGridDragHandler(
    lazyGridState: LazyGridState,
    selectedIds: () -> Set<Int>,
    autoScrollThreshold: Float,
    setSelectedIds: (Set<Int>) -> Unit = { },
    setAutoScrollSpeed: (Float) -> Unit = { },
) {
}
```

### Offset Extensions
Helper functions for calculating offsets during zoom and pan operations.

```kotlin
fun Offset.calculateNewOffset() {}
fun calculateDoubleTapOffset() {}
```

## Key Concepts and Techniques

1. **State Management**: Extensive use of `remember`, `mutableStateOf`, and `derivedStateOf` for efficient state handling.
2. **Gesture Handling**: Implementation of custom gesture detectors for drag, tap, and pinch actions.
3. **Custom Modifiers**: Creation of custom modifiers to encapsulate complex behaviors like drag selection.
4. **Compose Animation**: Usage of `updateTransition` for smooth animations in the UI.
5. **Accessibility**: Implementation of semantic properties for better accessibility support.
6. **Performance Optimization**: Use of `LazyVerticalGrid` for efficient large list rendering.
7. **Responsive Design**: Adaptive grid layout using `GridCells.Adaptive`.

## Conclusion
This code demonstrates a sophisticated implementation of a photo gallery app using Jetpack Compose. It showcases advanced UI interactions, efficient state management, and responsive design principles, making it a valuable reference for building complex UI applications in Kotlin with Compose.