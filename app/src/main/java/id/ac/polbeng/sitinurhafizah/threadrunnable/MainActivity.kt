package id.ac.polbeng.sitinurhafizah.threadrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.sitinurhafizah.threadrunnable.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val runnable = Worker()
            val thread = Thread(runnable)
            thread.start()
        }
    }
    inner class Worker : Runnable {
        override fun run() {
            killSomeTime()
        }
    }
    private fun killSomeTime() {
        for (i in 1..20) {
            Thread.sleep(2000)
            println("i: $i")
        }
    }
}