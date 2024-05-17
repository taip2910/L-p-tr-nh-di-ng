package com.example.ecommerceappjetpackcompose.utils.widgets

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.ecommerceappjetpackcompose.ui.theme.Purple500
import com.example.ecommerceappjetpackcompose.ui.theme.black
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabView(pagerState: PagerState,
                  modifier: Modifier, tabTitle: List<String>,
                  onTabSelected: (Int) -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()
    val tabIndex = pagerState.currentPage
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = modifier,
        backgroundColor = Color.White,
        contentColor = Color.White,
    ) {
        tabTitle.forEachIndexed { index, text ->
            val tabSelected = tabIndex == index
            Tab(
                selected = tabSelected,
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                    onTabSelected(index)
                },
                text = {
                    Text(
                        modifier = Modifier,
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        color = if (tabSelected) Purple500 else black,
                        maxLines = 1
                    )
                },
                selectedContentColor = Purple500,
                unselectedContentColor = black
            )
        }
    }
}