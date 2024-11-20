package com.chukimmuoi.jetchatbyme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
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
fun JetchatIcon(
    modifier: Modifier = Modifier,
    contentDescription: String?
) {
    val semantics = if (contentDescription != null) {
        modifier.semantics { //  Accessibility & Testing: https://developer.android.com/develop/ui/compose/accessibility/semantics
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }

    Box(modifier = modifier.then(semantics)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_jetchat_back),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primaryContainer,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_jetchat_front),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview
@Composable
private fun JetchatIconPreview() {
    JetchatByMeTheme {
        JetchatIcon(contentDescription = "")
    }
}