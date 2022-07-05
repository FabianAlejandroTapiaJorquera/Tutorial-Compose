package com.example.feriados

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.feriados.ui.theme.FeriadosTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp

private val mensajes: List<MisMensajes> = listOf(
    MisMensajes(titulo = "Titulo 1", body = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and"),
    MisMensajes(titulo = "Titulo 2", body = "f letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions ha"),
    MisMensajes(titulo = "Titulo 3", body = "Where can I get some? There are many variations of passages of Lorem Ipsum available, but the"),
    MisMensajes(titulo = "Titulo 4", body = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum "),
    MisMensajes(titulo = "Titulo 5", body = "Contrary to popular belief, Lorem Ipsum is not simply random text. It"),
    MisMensajes(titulo = "Titulo 6", body = "has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeriadosTheme {
                MisMensajes(mensajes)
            }
        }
    }
}

data class MisMensajes(val titulo: String, val body: String)

@Composable
fun MisElementos(mensaje: MisMensajes) {
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(all = 8.dp)) {
        MiImagen()
        MisTextos(mensaje.titulo, mensaje.body)
    }
}

@Composable
fun MiImagen() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "Imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
fun MisMensajes(mensajes: List<MisMensajes>) {
    LazyColumn {
        items(mensajes) { mensaje ->
             MisElementos(mensaje = mensaje)
        }
    }
}

@Composable
fun MisTextos(titulo: String, body: String) {
    Column(modifier = Modifier.padding(all = 8.dp)) {
        MiTexto(
            texto = titulo,
            color = MaterialTheme.colors.primary,
            estilo = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MiTexto(
            texto = body,
            color = MaterialTheme.colors.onBackground,
            estilo = MaterialTheme.typography.body1,
            lineas = 1
        )
    }
}

@Composable
fun MiTexto(texto: String, color: Color, estilo: TextStyle, lineas: Int = Int.MAX_VALUE) {
    Text(text = texto, color = color, style = estilo, maxLines = lineas)
}

@Preview(showSystemUi = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun VistaPrevia() {
    FeriadosTheme {
        MisMensajes(mensajes)
    }

}