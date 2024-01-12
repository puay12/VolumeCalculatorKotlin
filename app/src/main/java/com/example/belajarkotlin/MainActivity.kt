package com.example.belajarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        edtHeight = findViewById(R.id.edt_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            tvResult.text = savedInstanceState.getString(STATE_RESULT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            var isFieldEmpty = false

            if (inputLength.isEmpty() || inputWidth.isEmpty() || inputHeight.isEmpty()){
                isFieldEmpty = true
                if (inputLength.isEmpty()){
                    edtLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()){
                    edtWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()){
                    edtHeight.error = "Field ini tidak boleh kosong"
                }
            }

            if (!isFieldEmpty){
                tvResult.text = (inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()).toString()
            }
        }
    }
}