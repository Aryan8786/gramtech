package com.example.gramtech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gramtech.components.GramTechTopBar
import com.example.gramtech.components.StoryCard
import com.example.gramtech.data.SampleData
import com.example.gramtech.ui.theme.AmberContainer
import com.example.gramtech.ui.theme.AmberOnContainer

@Composable
fun StoriesScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            GramTechTopBar(
                title = "Success Stories",
                subtitle = "Rural Startup Case Studies",
                showBackButton = true,
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    Text(
                        text = "Rural Startup Stories",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Inspiring fictional case studies demonstrating technology adoption.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = AmberContainer)
                ) {
                    Text(
                        text = "Notice: All profiles below are created as demonstration case studies for this college project to illustrate how specific technologies solve typical rural supply and marketing problems.",
                        style = MaterialTheme.typography.bodySmall,
                        color = AmberOnContainer,
                        modifier = Modifier.padding(14.dp),
                        lineHeight = 18.sp
                    )
                }
            }

            items(SampleData.successStories, key = { it.id }) { story ->
                StoryCard(story = story)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
