package com.jaguar.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaguar.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.bg)
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
private fun UserInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .clip(CircleShape)
                .size(240.dp)
        )
        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(R.string.tagline),
            style = MaterialTheme.typography.headlineMedium,
            color = colorResource(R.color.subline),
            modifier = Modifier.padding(bottom = 100.dp),
        )
    }
}

@Composable
private fun UserContact(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.call_24px),
                contentDescription = "call details",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(R.string.phone),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.share_24px),
                contentDescription = "instagram handle",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(R.string.insta_handle),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.mail_24px),
                contentDescription = "email address",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = stringResource(R.string.email),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun Card() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserInfo()
        UserContact()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.bg)
        ) {
            Card()
        }
    }
}