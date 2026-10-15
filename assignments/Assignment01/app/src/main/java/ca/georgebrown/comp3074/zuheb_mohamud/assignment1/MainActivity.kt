package ca.georgebrown.comp3074.zuheb_mohamud.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Keep the 16dp padding from the XML AND add space for the system bars
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

        // 1. Get references to the views
        val editTextHours = findViewById<EditText>(R.id.editTextHours)
        val editTextRate = findViewById<EditText>(R.id.editTextRate)
        val editTextTax = findViewById<EditText>(R.id.editTextTax)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonAbout = findViewById<Button>(R.id.buttonAbout)
        val textViewPay = findViewById<TextView>(R.id.textViewPay)
        val textViewOvertime = findViewById<TextView>(R.id.textViewOvertime)
        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)
        val textViewTax = findViewById<TextView>(R.id.textViewTax)

        buttonCalculate.setOnClickListener {
            // 2. INPUT: read the text and convert it to numbers
            val hours = editTextHours.text.toString().toDoubleOrNull()
            val rate = editTextRate.text.toString().toDoubleOrNull()
            val taxRate = editTextTax.text.toString().toDoubleOrNull()

            if (hours == null || rate == null || taxRate == null) {
                Toast.makeText(this, R.string.error_invalid_input, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. CALCULATION: formulas from the assignment
            val pay: Double
            val overtimePay: Double
            if (hours <= 40) {
                pay = hours * rate
                overtimePay = 0.0
            } else {
                pay = 40 * rate
                overtimePay = (hours - 40) * rate * 1.5
            }
            val totalPay = pay + overtimePay
            val tax = pay * taxRate

            // 4. OUTPUT: show the results with 2 decimal places
            textViewPay.text = getString(R.string.result_pay, pay)
            textViewOvertime.text = getString(R.string.result_overtime, overtimePay)
            textViewTotal.text = getString(R.string.result_total, totalPay)
            textViewTax.text = getString(R.string.result_tax, tax)
        }

        // 5. NAVIGATION: open AboutActivity (separate from the Calculate listener)
        buttonAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}