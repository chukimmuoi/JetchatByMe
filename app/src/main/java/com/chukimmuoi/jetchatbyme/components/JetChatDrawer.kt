package com.chukimmuoi.jetchatbyme.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chukimmuoi.jetchatbyme.R
import com.chukimmuoi.jetchatbyme.ui.theme.JetchatByMeTheme

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: JetchatByMe
 * Created by chukimmuoi on 16/11/24.
 */
@Composable
fun JetchatDrawerContent(
    modifier: Modifier = Modifier,
    onProfileClicked: (String) -> Unit,
    onChatClicked: (String) -> Unit,
) {
    Column {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        DrawerHeader()
        DividerItem()
        DrawerItemHeader(
            modifier = modifier,
            text = "Chats"
        )
        ChatItem(
            text = "Composer",
            selected = true,
            onChatClicked = { onChatClicked("Composer") }
        )
        ChatItem(
            text = "Droidcon-nyc",
            selected = false,
            onChatClicked = { onChatClicked("Droidcon-nyc") }
        )
        DividerItem(
            modifier = Modifier.padding(horizontal = 28.dp)
        )
        DrawerItemHeader(text = "Recent Profiles")
        ProfileItem(
            text = "Ali Conors (you)",
            profilePic = null,
            onProfileClicked = {}
        )
        ProfileItem(
            text = "Taylor Brooks",
            profilePic = null,
            onProfileClicked = { onProfileClicked("") }
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun JetchatDrawerContentPreview() {
    JetchatByMeTheme {
        JetchatDrawerContent(
            onProfileClicked = {},
            onChatClicked = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun JetchatDrawerContentDarkPreview() {
    JetchatByMeTheme(darkTheme = true) {
        JetchatDrawerContent(
            onProfileClicked = {},
            onChatClicked = {}
        )
    }
}

@Composable
private fun DrawerHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        JetchatIcon(
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.jetchat_logo),
            contentDescription = null,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun DividerItem(
    modifier: Modifier = Modifier,
) {
    HorizontalDivider(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}

@Composable
private fun DrawerItemHeader(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .heightIn(min = 52.dp)
            .padding(horizontal = 28.dp),
        contentAlignment = CenterStart
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
private fun DrawerItemHeaderPreview() {
    JetchatByMeTheme {
        DrawerItemHeader(
            text = "Chats"
        )
    }
}

@Composable
private fun ChatItem(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onChatClicked: () -> Unit,
) {
    val background = if (selected) {
        Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    } else {
        Modifier
    }
    Row(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(CircleShape)
            .then(background)
            .clickable(onClick = onChatClicked),
        verticalAlignment = CenterVertically,
    ) {
        val iconTint = if (selected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_jetchat),
            tint = iconTint,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            contentDescription = null,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            },
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview
@Composable
private fun ChatItemPreview() {
    JetchatByMeTheme {
        ChatItem(
            text = "Chat items",
            selected = true,
            onChatClicked = {}
        )
    }
}

@Composable
private fun ProfileItem(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes profilePic: Int?,
    onProfileClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(CircleShape)
            .clickable(onClick = onProfileClicked),
        verticalAlignment = CenterVertically,
    ) {
        val paddingSizeModifier = Modifier
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
            .size(24.dp)
        if (profilePic != null) {
            Image(
                painter = painterResource(id = profilePic),
                modifier = paddingSizeModifier.then(Modifier.clip(CircleShape)),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        } else {
            Spacer(modifier = paddingSizeModifier)
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview
@Composable
private fun ProfileItemPreview() {
    JetchatByMeTheme {
        ProfileItem(
            text = "Profile items",
            profilePic = null,
            onProfileClicked = {}
        )
    }
}