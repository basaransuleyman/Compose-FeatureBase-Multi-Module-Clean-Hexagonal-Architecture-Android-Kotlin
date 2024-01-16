package com.example.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.ProductItem

@Composable
fun DetailBottomSheet(
    productItem: ProductItem
) {
    Column(modifier = Modifier.padding(16.dp)) {
        CoilImageComponent(
            imageUrl = productItem.productImage,
            contentDescription = "Bottom Sheet Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        productItem.text?.let { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
        productItem.subText?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
    }
}