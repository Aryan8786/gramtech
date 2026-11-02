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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gramtech.components.SchemeCard
import com.example.gramtech.data.SampleData
import com.example.gramtech.ui.theme.AmberContainer
import com.example.gramtech.ui.theme.AmberOnContainer

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import com.example.gramtech.ui.theme.GreenLight

@Composable
fun SchemesScreen(
    onSchemeClick: (String) -> Unit,
    onOpenWebPortal: ((url: String, title: String) -> Unit)? = null
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))
            Column {
                Text(
                    text = "Government Support",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "“Explore programs that may support entrepreneurs.”",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Live Web Portals Quick Bar
        if (onOpenWebPortal != null) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Language,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Live Official Portals (In-App Browser)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Tap to open and browse the live government websites directly inside GramTech:",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            item {
                                AssistChip(
                                    onClick = { onOpenWebPortal("https://www.mudra.org.in", "PM MUDRA Portal") },
                                    label = { Text("PM MUDRA") },
                                    leadingIcon = { Icon(Icons.Default.Language, null, modifier = Modifier.size(16.dp)) },
                                    colors = AssistChipDefaults.assistChipColors(containerColor = GreenLight)
                                )
                            }
                            item {
                                AssistChip(
                                    onClick = { onOpenWebPortal("https://www.startupindia.gov.in", "Startup India Portal") },
                                    label = { Text("Startup India") },
                                    leadingIcon = { Icon(Icons.Default.Language, null, modifier = Modifier.size(16.dp)) },
                                    colors = AssistChipDefaults.assistChipColors(containerColor = GreenLight)
                                )
                            }
                            item {
                                AssistChip(
                                    onClick = { onOpenWebPortal("https://www.standupmitra.in", "Stand-Up Mitra") },
                                    label = { Text("Stand-Up India") },
                                    leadingIcon = { Icon(Icons.Default.Language, null, modifier = Modifier.size(16.dp)) },
                                    colors = AssistChipDefaults.assistChipColors(containerColor = GreenLight)
                                )
                            }
                            item {
                                AssistChip(
                                    onClick = { onOpenWebPortal("https://pmvishwakarma.gov.in", "PM Vishwakarma Portal") },
                                    label = { Text("PM Vishwakarma") },
                                    leadingIcon = { Icon(Icons.Default.Language, null, modifier = Modifier.size(16.dp)) },
                                    colors = AssistChipDefaults.assistChipColors(containerColor = GreenLight)
                                )
                            }
                            item {
                                AssistChip(
                                    onClick = { onOpenWebPortal("https://udyamregistration.gov.in", "Udyam Registration") },
                                    label = { Text("Udyam MSME") },
                                    leadingIcon = { Icon(Icons.Default.Language, null, modifier = Modifier.size(16.dp)) },
                                    colors = AssistChipDefaults.assistChipColors(containerColor = GreenLight)
                                )
                            }
                        }
                    }
                }
            }
        }


        items(SampleData.schemes, key = { it.id }) { scheme ->
            SchemeCard(
                scheme = scheme,
                onClick = { onSchemeClick(scheme.id) }
            )
        }

        // Disclaimer at the bottom
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = AmberContainer)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = AmberOnContainer,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(24.dp)
                    )
                    Text(
                        text = "Scheme information is for educational purposes. Please verify current details on official government websites.",
                        style = MaterialTheme.typography.bodySmall,
                        color = AmberOnContainer,
                        lineHeight = 18.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
