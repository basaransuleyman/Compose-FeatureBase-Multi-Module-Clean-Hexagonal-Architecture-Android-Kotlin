package com.example.composefeaturebasedmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composefeaturebasedmultimodule.ui.theme.ComposeFeatureBasedMultiModuleTheme
import com.example.detail.presentation.DetailScreen
import com.example.detail.presentation.DetailSearchScreen
import com.example.home.presentation.HomeScreen
import com.example.list.presentation.ListScreen
import com.example.navigation.AppNavigation
import com.example.navigation.Navigator
import com.example.navigation.graph.DetailScreens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingleActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFeatureBasedMultiModuleTheme {
                AppNavigation(
                    navigator = navigator,
                    homeScreen = {
                        HomeScreen()
                    },
                    listScreen = {
                        ListScreen()
                    },
                    detailScreen = {// We can get args with "it" if we need
                        DetailScreen()
                    },
                    detailScreenWithGraph = DetailScreens(
                        detailMain = { DetailScreen() },
                        detailSearch = { DetailSearchScreen() }
                    )
                )
            }
        }
    }
}
