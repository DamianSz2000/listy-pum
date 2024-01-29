package com.example.quizapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.quizapp2.model.Question


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questions = mutableListOf(
            Question("Jakim symbolem oznaczamy siłę?",
                arrayOf("M", "P", "S", "F"), 3),
            Question("Czego skróconym opisem jest zdanie \"każdej akcji towarzyszy reakcja\"?",
                arrayOf("I ZASADY DYNAMIKI", "II ZASADY DYNAMIKI", "III ZASADY DYNAMIKI", "IV ZASADY DYNAMIKI"), 2),
            Question("Co określa się wzorem p = m*v ?",
                arrayOf("przyspieszenie", "prędkość", "pęd", "kierunek ruchu"), 2),
            Question("Jaka jest podstawowa jednostka natężenia prądu elektrycznego?",
                arrayOf("kelwin", "wolt", "dżul", "amper"), 3),
            Question("Kto jest autorem szczególnej teorii względności?",
                arrayOf("Isaac Newton", "Niels Bohr", "Nikola Tesla", "Albert Einstein"), 3),
            Question("Czego dotyczy prawo powszechnego ciążenia?",
                arrayOf("ciężaru", "grawitacji", "oporu elektrycznego", "indukcji magnetycznej"), 1),
            Question("Z którym pojęciem związane są hasła: kierunek, zwrot i moduł?",
                arrayOf("z pracą", "z prędkością światła", "z indukcją", "z wektorem"), 3),
            Question("Z czym związane jest prawo Ohma?",
                arrayOf("z natężeniem prądu", "z prędkością światła", "z grawitacją", "z teorią strun"), 0),
            Question("Jak inaczej powiemy na ugięcie się fali?",
                arrayOf("dyfrakcja", "dyfuzja", "dyfraktometria", "dyferencja"), 0),
            Question("Czego jednostką jest dżul?",
                arrayOf("oddziaływania magnetycznego", "energii kinetycznej", "przyspieszenia", "stałej grawitacji"), 1)
        )


        setContent {
            MyApp {
                QuizScreen(questions)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface {
            content()
        }
    }
}
