package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val bundleName = "newText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.titleTextView)
        val btn = findViewById<Button>(R.id.changeButton)

        tv.text = savedInstanceState?.getString(bundleName) ?: getString(R.string.hello_world)

        btn.setOnClickListener {
            tv.text = getString(R.string.i_am_an_android_developer)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(bundleName, getString(R.string.i_am_an_android_developer))
    }
}
