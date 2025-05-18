package com.example.andaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andaz.ui.theme.AndazTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val name = remember { mutableStateOf("andaz Kumar") }
    val memberSince = remember { mutableStateOf("member since Dec, 2020") }

    val creditScore = remember { mutableStateOf("757") }
    val cashback = remember { mutableStateOf("₹3") }
    val bankBalance = remember { mutableStateOf("check") }

    val cashbackBalance = remember { mutableStateOf("₹0") }
    val coins = remember { mutableStateOf("26,46,583") }
    val referral = remember { mutableStateOf("refer and earn") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                navigationIcon = {
                    IconButton(onClick = { /* back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* support */ }) {
                        Icon(Icons.Outlined.AccountCircle, contentDescription = "Support", tint = Color.White)
                    }
                }
            )
        },
        containerColor = Color.Black
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Profile Section
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(name.value, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(memberSince.value, color = Color.Gray, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* edit profile */ }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // CRED Garage card
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("get to know your vehicles, inside out", color = Color.White, fontSize = 14.sp)
                        Row {
                            Text("CRED garage", color = Color.Green, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Score & Balance Cards
            ProfileInfoItem("credit score", creditScore.value, Color.Green)
            ProfileInfoItem("lifetime cashback", cashback.value, Color.White)
            ProfileInfoItem("bank balance", bankBalance.value, Color.White)

            Spacer(modifier = Modifier.height(24.dp))

            Text("YOUR REWARDS & BENEFITS", color = Color.Gray, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))

            ProfileInfoItem("cashback balance", cashbackBalance.value, Color.White)
            ProfileInfoItem("coins", coins.value, Color.White)
            ProfileInfoItem("win upto Rs 1000", referral.value, Color.Green)

            Spacer(modifier = Modifier.height(24.dp))

            Text("TRANSACTIONS & SUPPORT", color = Color.Gray, fontSize = 12.sp)

            Spacer(modifier = Modifier.height(16.dp))

            ProfileInfoItem("all transactions", "", Color.White)

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Composable
fun ProfileInfoItem(title: String, value: String, valueColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(value, color = valueColor, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
    }
    Divider(color = Color.DarkGray)
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    AndazTheme {
        ProfileScreen()
    }
}