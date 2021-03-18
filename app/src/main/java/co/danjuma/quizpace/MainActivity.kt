package co.danjuma.quizpace

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.widget.Toast
import co.danjuma.quizpace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {

        private const val MAINACTIVITY_KEY = 1
    }


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN





        binding.btnGo.setOnClickListener {
            if (binding.etUsername.text.toString().isEmpty()) {

                Toast.makeText(this, "Please provide your name", Toast.LENGTH_SHORT).show()

            } else {
                val username =  binding.etUsername.text.toString()
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("MAINACTIVITY_KEY", username.toString())
                startActivity(intent)
            }
        }

    }
}