package com.example.listeners

import android.location.GnssAntennaInfo.Listener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etNumero.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.btnRestar.setBackgroundColor(getColor(R.color.purple_200))
                binding.btnSumar.setBackgroundColor(getColor(R.color.purple_200))
            } else {

                binding.btnRestar.setBackgroundColor(getColor(R.color.black))
                binding.btnSumar.setBackgroundColor(getColor(R.color.black))
            }
        }

        //se ingresa un numero en el edittext
        binding.etNumero.addTextChangedListener {
            binding.tvNumero.text = it.toString()
            //quitar el focus del edittext
            binding.etNumero.clearFocus()
        }

        //se suma uno al numero del textview
        binding.btnSumar.setOnClickListener {
            val numero = binding.tvNumero.text.toString().toInt()
            binding.tvNumero.text = (numero + 1).toString()

        }

        //se resta uno al numero del textview
        binding.btnRestar.setOnClickListener {
            //si es menor que 0 no se resta
            if (binding.tvNumero.text.toString().toInt() > 0) {
                val numero = binding.tvNumero.text.toString().toInt()
                binding.tvNumero.text = (numero - 1).toString()
            }else
            {
                binding.tvNumero.text = "0"
                Toast.makeText(this, "No se puede restar", Toast.LENGTH_SHORT).show()
            }

        }




    }
}
