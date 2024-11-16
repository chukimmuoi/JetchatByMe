package com.chukimmuoi.jetchatbyme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chukimmuoi.jetchatbyme.ui.theme.JetchatByMeTheme

/**
 * Dùng AppCompatActivity:
 *
 * Khi cần hỗ trợ tương thích ngược cho các tính năng hiện đại.
 * Khi dự án sử dụng giao diện XML truyền thống với Action Bar hoặc Drawer Menu.
 *
 * Dùng ComponentActivity:
 *
 * Khi sử dụng Jetpack Compose.
 * Khi muốn tổ chức logic ứng dụng linh hoạt và tránh cấu trúc kế thừa phức tạp.
 * */
class NavActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetchatByMeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetchatByMeTheme {
        Greeting("Android")
    }
}