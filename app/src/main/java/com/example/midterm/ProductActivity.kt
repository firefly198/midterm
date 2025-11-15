package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODUCT_PRICE = "product_price"
    }

    private val productPrice = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val addToCartButton: Button = findViewById(R.id.AddBtn)

        addToCartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT_PRICE, productPrice)
            startActivity(intent)
        }
    }
}