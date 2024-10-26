@file:OptIn(ExperimentalFoundationApi::class)

package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject.ui.theme.FinalProjectTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           //OnBoardingScreen()
           NavLogic()
        }
    }
}

data class ScreenInfo(
    val image : Int,
    val description : String
)

val screen= listOf(
    ScreenInfo(R.drawable.wfh_4, "Узнавай о премьерах"),
    ScreenInfo(R.drawable.wfh_8, "Создавай коллекции"),
    ScreenInfo(R.drawable.wfh_2, "Делись с друзьями")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen () {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { screen.size })
    val scope = rememberCoroutineScope()

    Column (
        modifier =Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Spacer(modifier = Modifier.height(55.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Skillcinema",
                color = Color(0xFF272727),
                fontSize = 20.sp
            )
            Button (
                onClick = {
                    scope.launch {
                        val curr = if (pagerState.currentPage == screen.size-1) {
                            0
                        }else{
                            pagerState.currentPage+1
                        }
                        pagerState.scrollToPage(curr)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(text = "Пропустить",
                    color = Color(0xFFB5B5C9)
                )
            }

        }
        Spacer(modifier = Modifier.height(190.dp))

        HorizontalPager(
              state = pagerState
        ) {screenIndex->
            val screenData = screen[screenIndex]

            Column (
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(screenData.image),
                    contentDescription = null,
                    modifier = Modifier.width(360.dp).height(270.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))

                val descNew = screenData.description.replaceFirst(" ", "\n")

                Text( text = descNew,
                    fontSize = 40.sp,
                    color = Color(0xFF272727),
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 20.dp),

                )


            }
        }
        Spacer(modifier = Modifier.height(40.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
        ){
           Row (
                 horizontalArrangement = Arrangement.Center
              ) {
                  for (i in screen.indices){
                    val color = if (i == pagerState.currentPage) Color(0xFF121616) else Color(0xFFD9D9D9)
                     Box(modifier = Modifier.size(20.dp).padding(4.dp)
                    .background(color, CircleShape))
                  }
              }
        }
    }

}

@Preview
@Composable
fun OnBoardingScreenPreview () {
    OnBoardingScreen()
}