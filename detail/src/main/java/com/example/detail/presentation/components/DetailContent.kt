package com.example.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.detail.domain.model.ItemDetail

@Composable
fun DetailContent(
    itemData: ItemDetail
) {
    Column(modifier = Modifier.padding(16.dp)) {
        CoilImageComponent(
            imageUrl = itemData.productImage,
            contentDescription = "Detail Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(itemData.productName, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(4.dp))
        Text(itemData.subText, style = MaterialTheme.typography.bodyMedium)
    }
}
