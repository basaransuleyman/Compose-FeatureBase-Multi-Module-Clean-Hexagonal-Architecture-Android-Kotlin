package com.example.home.presentation.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.ProductItem
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun SlidableSection(
    productItems: List<ProductItem>,
    sectionTitle: String,
    onProductClick: (HomeUIEvent) -> Unit
) {
    Column {
        SectionTitle(title = sectionTitle)
        LazyRow {
            items(items = productItems, key = { product ->
               product.productId
            }) { product ->
                HorizontalCard(
                    product.productImage,
                    product.text,
                    product.subText,
                    onClick = { onProductClick(HomeUIEvent.OnProductClicked) })
            }
        }
    }
}

@Composable
fun HorizontalCard(
    imageUri: String,
    title: String?,
    subTitle: String?,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            CoilImageComponent(
                imageUri, contentDescription = "Slidable Image", modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            if (title != null) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            if (subTitle != null) {
                Text(
                    text = subTitle,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }
    }
}
