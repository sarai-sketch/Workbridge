package com.workbridge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.workbridge.R
import com.workbridge.ui.theme.WorkBridgeTheme

val PrimaryOrange = Color(0xFFFF6D00)
val LightBeigeBackground = Color(0xFFF7F4EB)
val CardBackground = Color(0xFFFCFBF9)
val TextDark = Color(0xFF1A1A1A)
val TextGray = Color(0xFF666666)
val SoftOrangeBg = Color(0xFFFFE0B2)

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { WorkBridgeTopBar() },
        bottomBar = { WorkBridgeBottomBar() },
        containerColor = LightBeigeBackground,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            WelcomeSection(userName = "Carlos")
            MatchSection()
            ToolsSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun WorkBridgeTopBar() {
    Surface(
        color = LightBeigeBackground,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_work_bridge),
                    contentDescription = "Logo WorkBridge",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(SoftOrangeBg)
                        .border(1.5.dp, PrimaryOrange, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "WorkBridge",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }

            IconButton(
                onClick = { /* Notificaciones */ },
                modifier = Modifier
                    .size(42.dp)
                    .background(CardBackground, CircleShape)
                    .border(1.dp, Color(0xFFE0DCD0), CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificaciones",
                    tint = TextDark,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun WelcomeSection(userName: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "¡Hola, $userName!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Tu camino al éxito profesional",
                        fontSize = 14.sp,
                        color = TextGray,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = SoftOrangeBg
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = PrimaryOrange,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Activo",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryOrange
                        )
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFEFECE4), thickness = 1.dp)

            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Progreso de tu reinserción laboral",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextDark
                    )
                    Text(
                        text = "80%",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange
                    )
                }
                LinearProgressIndicator(
                    progress = { 0.8f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = PrimaryOrange,
                    trackColor = Color(0xFFEFECE4),
                )
                Text(
                    text = "¡Estás a un paso de completar tu perfil óptimo para reclutadores!",
                    fontSize = 12.sp,
                    color = TextGray
                )
            }
        }
    }
}

@Composable
fun MatchSection() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = "IA",
                    tint = PrimaryOrange,
                    modifier = Modifier.size(22.dp)
                )
                Text(
                    text = "Recomendaciones para ti (IA)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }
            Text(
                text = "Ver más",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryOrange
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            JobMatchCard(
                matchPercentage = "94% Match IA",
                jobTitle = "Desarrollador Android",
                company = "TechSolutions Global",
                location = "Remoto",
                salary = "$2,500 - $3,200 / mes",
                tags = listOf("Kotlin", "Jetpack Compose", "Coroutines")
            )
            JobMatchCard(
                matchPercentage = "89% Match IA",
                jobTitle = "Analista de Operaciones",
                company = "Logística Avanzada S.A.",
                location = "Híbrido",
                salary = "$1,800 - $2,200 / mes",
                tags = listOf("Excel", "Procesos", "Scrum")
            )
            JobMatchCard(
                matchPercentage = "85% Match IA",
                jobTitle = "Soporte Técnico IT",
                company = "Global Services Inc.",
                location = "Presencial",
                salary = "$1,500 - $1,900 / mes",
                tags = listOf("Redes", "Helpdesk", "Hardware")
            )
        }
    }
}

@Composable
fun JobMatchCard(
    matchPercentage: String,
    jobTitle: String,
    company: String,
    location: String,
    salary: String,
    tags: List<String>
) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(220.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = SoftOrangeBg
                    ) {
                        Text(
                            text = matchPercentage,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryOrange
                        )
                    }
                    Text(
                        text = location,
                        fontSize = 12.sp,
                        color = TextGray,
                        fontWeight = FontWeight.Medium
                    )
                }

                Column {
                    Text(
                        text = jobTitle,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = company,
                        fontSize = 13.sp,
                        color = TextGray,
                        maxLines = 1
                    )
                }

                Text(
                    text = salary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryOrange
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    tags.take(2).forEach { tag ->
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFFF0ECE1)
                        ) {
                            Text(
                                text = tag,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
                                fontSize = 10.sp,
                                color = TextDark
                            )
                        }
                    }
                }
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Postular o Ver detalles",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ToolsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "Herramientas de impulso",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            ToolItemCard(
                title = "Preparación de CV con IA",
                description = "Optimiza tu currículum automáticamente para destacar ante reclutadores.",
                icon = Icons.Default.Description
            )
            ToolItemCard(
                title = "Simulador de Entrevista",
                description = "Practica preguntas frecuentes con nuestro asistente virtual inteligente.",
                icon = Icons.Default.Videocam
            )
            ToolItemCard(
                title = "Seguimiento de Postulaciones",
                description = "Monitorea el estatus de tus candidaturas en tiempo real.",
                icon = Icons.Default.List
            )
        }
    }
}

@Composable
fun ToolItemCard(
    title: String,
    description: String,
    icon: ImageVector
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = SoftOrangeBg,
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title,
                        tint = PrimaryOrange,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Ir",
                tint = TextGray,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun WorkBridgeBottomBar() {
    NavigationBar(
        containerColor = CardBackground,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio", fontWeight = FontWeight.Bold) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryOrange,
                selectedTextColor = PrimaryOrange,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray,
                indicatorColor = SoftOrangeBg
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryOrange,
                selectedTextColor = PrimaryOrange,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray,
                indicatorColor = SoftOrangeBg
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Work, contentDescription = "Postulaciones") },
            label = { Text("Postulaciones") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryOrange,
                selectedTextColor = PrimaryOrange,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray,
                indicatorColor = SoftOrangeBg
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryOrange,
                selectedTextColor = PrimaryOrange,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray,
                indicatorColor = SoftOrangeBg
            )
        )
    }
}

@Preview(showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun MainScreenPreview() {
    WorkBridgeTheme {
        MainScreen()
    }
}
