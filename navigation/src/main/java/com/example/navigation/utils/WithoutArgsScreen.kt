package com.example.navigation.utils

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry

abstract class WithoutArgsScreen : NodeScreen, NavDestination<Unit> {
    override val arguments: List<NamedNavArgument> get() = emptyList()
    override fun objectParser(entry: NavBackStackEntry) {}
    override fun destination(arg: Unit): DestinationRoute = route
}