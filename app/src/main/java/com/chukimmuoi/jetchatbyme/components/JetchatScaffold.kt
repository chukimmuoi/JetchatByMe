package com.chukimmuoi.jetchatbyme.components

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.DrawerValue.Open
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
fun JetChatDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(initialValue = Closed),
    onProfileClicked: (String) -> Unit,
    onChatClicked: (String) -> Unit,
    content: @Composable () -> Unit,
) {
    JetchatByMeTheme {
        ModalNavigationDrawer( // https://developer.android.com/develop/ui/compose/components/drawer?hl=vi
            modifier = modifier,
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = MaterialTheme.colorScheme.background,
                    drawerContentColor = MaterialTheme.colorScheme.onBackground,
                ) {
                    JetchatDrawerContent(
                        onProfileClicked = onProfileClicked,
                        onChatClicked = onChatClicked,
                    )
                }
            },
            content = content,
        )
    }
}

@Preview
@Composable
private fun JetChatDrawerPreview() {
    JetchatByMeTheme {
        JetChatDrawer(
            drawerState = rememberDrawerState(initialValue = Open),
            onProfileClicked = {},
            onChatClicked = {},
            content = {}
        )
    }
}