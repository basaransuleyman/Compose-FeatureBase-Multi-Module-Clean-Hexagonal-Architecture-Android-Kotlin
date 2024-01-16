package com.example.home.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.ProductItem

@Composable
fun VerticalSection(productItems: List<ProductItem>, sectionTitle: String) {
    Column {
        SectionTitle(title = sectionTitle)
        productItems.forEach { product ->
            ProductItemCard(product)
        }
    }
}

@Composable
fun ProductItemCard(item: ProductItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoilImageComponent(
                imageUrl = item.productImage,
                contentDescription = "Vertical Image",
                modifier = Modifier.size(88.dp)
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                item.text?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                item.subText?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }


    }
}