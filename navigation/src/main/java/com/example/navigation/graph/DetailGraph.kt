package com.example.navigation.graph

import com.example.navigation.screens.detaiwithowngraph.DetailMain
import com.example.navigation.screens.detaiwithowngraph.DetailSearch
import com.example.navigation.utils.NavigationGraph

object DetailGraph : NavigationGraph {
    override val route: String
        get() = "detailgraph"
    override val startDestination: String
        get() = detailMain.destination(Unit)

    val detailMain = DetailMain
    val detailSearch = DetailSearch
}