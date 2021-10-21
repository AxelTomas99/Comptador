package me.axeltomas.dam.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton: Button
    internal lateinit var timeTextView: TextView
    internal lateinit var counterTextView: TextView
    internal var counter = 0
    internal var time = 10

    internal var appStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDownTimer: Long = 5000
    internal val intervalCountDownTimer: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountdown()

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
//      Actualitzar o definir valor inicial de counterTextView -> counterTextView= counter -> 0
        tapMeButton.setOnClickListener {
            if (!appStarted) {
                //startGame()
                startGame()
            }
            incrementCounter()
        }
//        timeTextView.text = time.toString()
        timeTextView.text = getString(R.string.timeText, time)

    }

    private fun startGame() {
        countDownTimer.start()
        appStarted = true
    }

    private fun initCountdown() {
        countDownTimer = object : CountDownTimer(initialCountDownTimer, intervalCountDownTimer) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timeTextView.text = timeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }
        }

    }

    private fun incrementCounter() {
//                counter = counter +1;
        counter += 1;
        counterTextView.text = counter.toString()
    }

    private fun endGame(){
        Toast.makeText(this,getString(R.string.endGame), Toast.LENGTH_LONG).show();
        Toast.makeText(this,getString(R.string.restartGame, counter), Toast.LENGTH_LONG).show();
        resetGame();
    }


    private fun resetGame(){
        appStarted=false
        counter = 0;
        counterTextView.text = counter.toString()
        initCountdown();
        timeTextView.text = getString(R.string.timeText, time);
    }
}