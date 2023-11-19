package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val tv = findViewById<TextView>(R.id.titleTextView)
        val btn = findViewById<Button>(R.id.changeButton)

        btn.setOnClickListener {
            tv.text = getString(R.string.i_am_an_android_developer)
        }
    }

}