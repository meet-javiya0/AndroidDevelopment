package com.example.viewbindingandcheckbox

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbindingandcheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (binding.checkBox.isChecked) {
                binding.etName.setText("")
                binding.etEmail.setText("")
                Toast.makeText(this, "Signed up successfully!", Toast.LENGTH_SHORT).show()
            } else {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.BLUE)
                Toast.makeText(this, "Please accept T&C!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.checkBox.setOnClickListener {
            binding.checkBox.buttonTintList = ColorStateList.valueOf(Color.GREEN)
        }
    }
}