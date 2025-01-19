package com.meet.movieapp.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.meet.movieapp.model.Movie
import com.meet.movieapp.model.getMovies
import com.meet.movieapp.navigation.MovieScreens
import com.meet.movieapp.widgets.MovieRow

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Movies") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        )
    })

    { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
            // color = MaterialTheme.colorScheme.primaryContainer
        ) {
            MainContent(navController = navController)
        }

    }


}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    LazyColumn {
        items(items = movieList) {
            MovieRow(movie = it){movie ->
                navController.navigate(MovieScreens.DetailsScreen.name+"/$movie")

            }
        }
    }
}