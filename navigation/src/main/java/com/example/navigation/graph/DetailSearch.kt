package com.example.navigation.screens.detaiwithowngraph

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.example.navigation.utils.ArgsScreen
import com.example.navigation.utils.DestinationRoute

object DetailSearch :ArgsScreen<Unit>{
    override fun destination(arg: Unit): DestinationRoute= route

    override val route: String = "detail/search"
    override val arguments: List<NamedNavArgument> = emptyList()

    override fun objectParser(entry: NavBackStackEntry) {}
}