package me.axeltomas.dam.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton: Button
    internal lateinit var timeTextView: TextView
    internal lateinit var counterTextView: TextView
    internal var counter = 0
    internal var time = 60


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
//      Actualitzar o definir valor inicial de counterTextView -> counterTextView= counter -> 0
//      TODO en algun moment haurem d'executar aquesta funció
        tapMeButton.setOnClickListener{
            incrementCounter()
//      TODO -> Iniciar el comptador

        }
//        timeTextView.text = time.toString()
          timeTextView.text = getString(R.string.timeText, time)

    }

    private fun incrementCounter() {
//                counter = counter +1;
        counter += 1;
        counterTextView.text = counter.toString()
    }
}