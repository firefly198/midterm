package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    private var quantity = 2
    private var unitPrice = 0
    private lateinit var totalTextView: TextView
    private lateinit var quantityTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val placeOrderButton: Button = findViewById(R.id.placeOrderButton)
        val backButton: ImageButton = findViewById(R.id.oval)
        val plusButton: ImageButton = findViewById(R.id.plus)
        val minusButton: ImageButton = findViewById(R.id.minus)
        totalTextView = findViewById(R.id.totalValue)
        quantityTextView = findViewById(R.id.quantityText)

        unitPrice = intent.getIntExtra(ProductActivity.EXTRA_PRODUCT_PRICE, 120)

        updateQuantityDisplay()
        updateTotal()

        plusButton.setOnClickListener {
            quantity++
            updateQuantityDisplay()
            updateTotal()
        }

        minusButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantityDisplay()
                updateTotal()
            }
        }

        backButton.setOnClickListener {
            finish()
        }

        placeOrderButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateTotal() {
        val total = unitPrice * quantity
        totalTextView.text = "$total $"
    }

    private fun updateQuantityDisplay() {
        quantityTextView.text = quantity.toString()
    }
}