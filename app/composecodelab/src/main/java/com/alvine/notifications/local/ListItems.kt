package com.alvine.notifications.local

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import com.alvine.composecodelab.R

@Composable
fun ListItems(
    modifier: Modifier = Modifier,
    data: List<ComposeRandomItem> = DataSource.plants.map { it }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = data.toMutableList()) { n ->
            ComposeCard(
                name =ComposeRandomItem.name,
                type = n.type,
                description = n.description
            )
        }
    }

    val notification = NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("2 new messages with $sender")
        .setContentText(subject)
        .setSmallIcon(R.drawable.new_message)
        .setStyle(
            NotificationCompat.MessagingStyle(user)
            .addMessage(messages[1].getText(), messages[1].getTime(), messages[1].getPerson())
            .addMessage(messages[2].getText(), messages[2].getTime(), messages[2].getPerson())
        )
        .build()

}

