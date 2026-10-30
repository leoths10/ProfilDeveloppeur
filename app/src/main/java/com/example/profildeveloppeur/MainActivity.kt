package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfilScreen(
                        nom = "Léo THOMAS",
                        role = "Développeur Full-Stack",
                        description = "Etudiant en Ingéniérie du web en Master1 à L'ESGI de TOURS, Actuellement en Alternance",
                        competence1 = "Typescript",
                        competence2 = "Php",
                        competence3 = "Python",
                        disponibilite = "Actuellement en alternance",
                        onContactClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Competence(nom: String, modifier: Modifier = Modifier){
    Text(
        text = "* $nom",
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CompetencePreview(){
    ProfilDeveloppeurTheme() {
        Competence(nom = "Kotlin")
    }
}

@Composable
fun ProfilHeader(nom: String, role: String, modifier: Modifier = Modifier){
    Column(modifier = modifier){
        Text(text = nom, style = MaterialTheme.typography.headlineMedium)
        Text(text = role, style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilHeaderPreview(){
    ProfilDeveloppeurTheme {
        ProfilHeader(nom = "Léo THOMAS", role = "Développeur Full-Stack")
    }
}

@Composable
fun ActionButton(texte: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = texte)
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    ProfilDeveloppeurTheme {
        ActionButton(texte = "Contacter", onClick = {})
    }
}

@Composable
fun InfoDisponibilite(texte: String, modifier: Modifier = Modifier){
    Text(
        text = texte,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun InfoDisponibilitePreview(){
    ProfilDeveloppeurTheme {
        InfoDisponibilite(texte = "Actuellement en Alternance")
    }
}

@Composable
fun ProfilCard(
    nom : String,
    role: String,
    description: String,
    competence1: String,
    competence2: String,
    competence3: String,
    disponibilite: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
    ){
        Column(modifier = Modifier.padding(16.dp)){
            ProfilHeader(nom = nom, role = role)
            Text(
                text = description,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "Compétences",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Competence(nom = competence1, modifier = Modifier.padding(top = 8.dp))
            Competence(nom = competence2, modifier = Modifier.padding(top = 8.dp))
            Competence(nom = competence3, modifier = Modifier.padding(top = 8.dp))
            InfoDisponibilite(
                texte = disponibilite,
                modifier = Modifier.padding(top = 16.dp)
            )
            ActionButton(
                texte = "Contacter",
                onClick = onContactClick,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun ProfilScreen(
    nom: String,
    role: String,
    description: String,
    competence1: String,
    competence2: String,
    competence3: String,
    disponibilite: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        ProfilCard(
            nom = nom,
            role = role,
            description = description,
            competence1 = competence1,
            competence2 = competence2,
            competence3 = competence3,
            disponibilite = disponibilite,
            onContactClick = onContactClick,
            modifier = Modifier.padding(16.dp)
        )
    }
}
