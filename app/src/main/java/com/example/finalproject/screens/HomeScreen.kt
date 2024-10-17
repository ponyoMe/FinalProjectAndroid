package com.example.finalproject.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalproject.R

data class MovieItem(
    val title: String,
    val genre: String,
    val imageRes: Int
)

val premieres = listOf(
    MovieItem("Дюна", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Человек-паук: Нет пути домой", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Не время умирать", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Матрица: Воскрешение", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Король Ричард", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Французский вестник", "Комедия", R.drawable.ic_launcher_foreground),
    MovieItem("Красное уведомление", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Круэлла", "Комедия", R.drawable.ic_launcher_foreground),
    MovieItem("Главный герой", "Комедия", R.drawable.ic_launcher_foreground),
    MovieItem("Последняя дуэль", "Драма", R.drawable.ic_launcher_foreground)
)

val popular = listOf(
    MovieItem("Мстители: Финал", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Джокер", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Оно", "Ужасы", R.drawable.ic_launcher_foreground),
    MovieItem("Звезда родилась", "Мюзикл", R.drawable.ic_launcher_foreground),
    MovieItem("Чёрная Пантера", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Холодное сердце 2", "Мультфильм", R.drawable.ic_launcher_foreground),
    MovieItem("Гарри Поттер и Дары Смерти", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Интерстеллар", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Паразиты", "Триллер", R.drawable.ic_launcher_foreground),
    MovieItem("Достать ножи", "Триллер", R.drawable.ic_launcher_foreground)
)

val actionMovies = listOf(
    MovieItem("Мстители: Война бесконечности", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Форсаж 9", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Снайпер", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Бэтмен против Супермена", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Аквамен", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Миссия невыполнима: Последствия", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Звёздные войны: Пробуждение силы", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Тёмный рыцарь", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Гладиатор", "Боевик", R.drawable.ic_launcher_foreground),
    MovieItem("Чудо-женщина", "Боевик", R.drawable.ic_launcher_foreground)
)

val dramaMovies = listOf(
    MovieItem("Зелёная книга", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("1917", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Игра в имитацию", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Список Шиндлера", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Побег из Шоушенка", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Форд против Феррари", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Красота по-американски", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Титаник", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("В погоне за счастьем", "Драма", R.drawable.ic_launcher_foreground),
    MovieItem("Реквием по мечте", "Драма", R.drawable.ic_launcher_foreground)
)

val sciFiMovies = listOf(
    MovieItem("Бегущий по лезвию 2049", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Интерстеллар", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Начало", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Матрица", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Звёздные войны", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Гарри Поттер и философский камень", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Звёздный путь", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Трансформеры", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Гравитация", "Фантастика", R.drawable.ic_launcher_foreground),
    MovieItem("Первому игроку приготовиться", "Фантастика", R.drawable.ic_launcher_foreground)
)

val documentaryMovies = listOf(
    MovieItem("Моя октава", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Человек с Земли", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Земля", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Море внутри", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Чёрный рыцарь", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Планета Земля", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Руководство по выживанию", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Марс", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("Наркотики", "Документальный", R.drawable.ic_launcher_foreground),
    MovieItem("В поисках Граффити", "Документальный", R.drawable.ic_launcher_foreground)
)
@Composable
fun MovieItemView(item: MovieItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .width(110.dp).height(150.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontSize = 16.sp)
        Text(text = item.genre, fontSize = 12.sp, color = Color.Gray)
    }
}
@Composable
fun MovieSection(title: String,
                 movies: List<MovieItem>,
                 onClick: (MovieItem) -> Unit,
                 onShowAllClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.h6)
            Text(text = "Все", color = MaterialTheme.colors.primary, modifier = Modifier.clickable { onShowAllClick() })
        }

        LazyRow(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(movies) { movie ->
                MovieItemView(item = movie, onClick = { onClick(movie) })
            }

            item {
                ShowAllButton (onClick=onShowAllClick)
            }
        }


    }
}

@Composable
fun ShowAllButton(onClick: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxHeight()
            //.padding(8.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Show all",
                tint = Color.Blue,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Показать все",
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}


@Composable
fun HomeSc() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item{
        Spacer(modifier = Modifier.height(50.dp))
        }

        item {
            Text(text = "Skillcinema",
                color = Color(0xFF272727),
                fontSize = 26.sp,
                modifier = Modifier.padding(start = 14.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            MovieSection(
                title = "Премьеры",
                movies = premieres,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }

        item {
            MovieSection(
                title = "Популярное",
                movies = popular,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }

        item {
            MovieSection(
                title = "Боевики США",
                movies = actionMovies,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }

        item {
            MovieSection(
                title = "Топ-250",
                movies = sciFiMovies,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }

        item {
            MovieSection(
                title = "Драмы Франции",
                movies = dramaMovies,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }

        item {
            MovieSection(
                title = "Сериалы",
                movies = documentaryMovies,
                onClick = { movie ->
                    Log.d("HomePage", "Кликнули по фильму: ${movie.title}")
                },
                onShowAllClick = {
                    Log.d("HomePage", "Показать все популярные фильмы")
                }
            )
//
        }


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        HomeSc()
    }
}

