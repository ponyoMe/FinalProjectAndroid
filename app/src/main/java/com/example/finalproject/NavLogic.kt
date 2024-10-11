package com.example.finalproject

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.screens.HomeSc
import com.example.finalproject.screens.ProfileScreen
import com.example.finalproject.screens.SearchScreen



@Composable
fun NavLogic() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) { innerPadding ->
        NavigationGraph(navController, Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNav(
    navController: NavHostController
) {
    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Search,
        BottomNavItems.Profile
    )

    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = screen.icon),
                        contentDescription = screen.route,
                        modifier = Modifier.size(30.dp))
                },
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                selected = false
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = BottomNavItems.Home.route, modifier = modifier) {
        composable(BottomNavItems.Home.route) {
            HomeSc()
        }
        composable(BottomNavItems.Search.route) {
            SearchScreen()
        }
        composable(BottomNavItems.Profile.route) {
             ProfileScreen()
        }
    }
}

sealed class BottomNavItems(val icon: Int, val route: String) {
    object Home : BottomNavItems(R.drawable.icons, "home")
    object Search : BottomNavItems(R.drawable.ic, "search")
    object Profile : BottomNavItems(R.drawable.ic1, "profile")
}
