package ca.georgebrown.comp3074.zuheb_mohamud.assignment1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        // Same padding fix as MainActivity
        val mainView = findViewById<View>(R.id.main)
        val basePadding = mainView.paddingLeft
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                bars.left + basePadding,
                bars.top + basePadding,
                bars.right + basePadding,
                bars.bottom + basePadding
            )
            insets
        }

        // Title + back arrow in the ActionBar
        supportActionBar?.title = getString(R.string.title_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Called when the back arrow in the ActionBar is pressed
    override fun onSupportNavigateUp(): Boolean {
        finish()   // close this screen and return to the EXISTING MainActivity
        return true
    }
}