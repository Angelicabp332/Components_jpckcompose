package com.example.componentsjpckcompose

import android.graphics.Color
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.componentsjpckcompose.ui.theme.ComponentsJpckcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsJpckcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    SimpleComposable()
                }
            }
        }
    }
}

@Composable
fun SimpleComposable() {

    var textFieldValue by remember { mutableStateOf("") }
    var textValue by remember { mutableStateOf("Reparaciones App") }


    Column(
        Modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.centerHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription ="IImagen de fondo",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textValue,
            style = TextStyle(
                color = Color.BLACK,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black
                textAlign = TextAlign.center )
        )
        
        TextField(
            value = TextFieldValue(),
            onValueChange = { },
            label ={
                Text( "Escriba aqui")
            },
            leadingIcon = {
                Icon(
                    modifier= Modifier.size(24.dp)
                    painter = PainterResource(id= R.drawable.ic_launcher_foreground),
                    contentDescription = "Icono")
            }
        )
        Button(
            onClick = { textValue = TextFieldValue.toString() }
        )
        {
            Text("Aceptar")
            
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComponentsJpckcomposeTheme {
        SimpleComposable()
    }
}