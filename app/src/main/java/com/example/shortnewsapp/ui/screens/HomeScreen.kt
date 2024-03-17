package com.example.shortnewsapp.com.example.shortnewsapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shortnewsapp.com.example.shortnewsapp.ui.components.Loader
import com.example.shortnewsapp.com.example.shortnewsapp.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState


const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
){
    val newsRes = newsViewModel.news.collectAsState().value

    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        when(newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG, "Inside_Success ${response.status} ${response.totalResults}")
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside_Error")
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}