package com.example.listeners

import android.location.GnssAntennaInfo.Listener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import com.example.listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //seteamos el layout principal mediante activityMainBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //cuando no se este escribiendo en el edittext se cambia el color de fondo de los botones

        binding.etNumero.addTextChangedListener {
            binding.btnSumar.setBackgroundColor(getColor(R.color.purple_200))
            binding.btnRestar .setBackgroundColor(getColor(R.color.purple_200))

        }


        //cuando se hace click en el boton sumar se suma 1 al
        // numero que se encuentra en el textview

        binding.btnSumar.setOnClickListener {
            binding.btnSumar.setBackgroundColor(getColor(R.color.black))
            binding.btnRestar.setBackgroundColor(getColor(R.color.black))
            var numero = binding.tvNumero.text.toString().toInt()
            numero++
            binding.tvNumero.text = numero.toString()
        }



        //cuando se hace click en el boton restar se resta 1 al numero que se encuentra en el edittext

        binding.btnRestar.setOnClickListener {
            var numero = binding.tvNumero.text.toString().toInt()
            if (numero > 0) {
                numero--
                binding.tvNumero.text = numero.toString()
            }else{
                binding.tvNumero.text = "0"
            }
            binding.btnSumar.setBackgroundColor(getColor(R.color.black))
            binding.btnRestar.setBackgroundColor(getColor(R.color.black))
        }


    }
}