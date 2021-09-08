package com.marcelodonato.imc_app


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.height_main_activity.*
import kotlinx.android.synthetic.main.weight_main_activity.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    var height: Double = 0.0
    var weight: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeight()
        setWeight()
        setCalculate()

    }

    private fun setHeight() {
        tvHeight.text = height.toString()


        setHeightButtons()
    }

    private fun setHeightButtons() {

        button_more_height.setOnClickListener {
            height++
            setHeight()
        }

        button_less_height.setOnClickListener {
            height--

            if (height < 0.0) {
                height = 0.0
                print(height)
                toast(getString(R.string.error))
            }
            setHeight()
        }
    }

    private fun setWeight() {
        tvWeight.text = weight.toString()
        setWeightButtons()
    }

    private fun setWeightButtons() {
        button_more_weight.setOnClickListener {
            weight++
            setWeight()
        }
        button_less_weigth.setOnClickListener {
            weight--

            if (weight < 0.0) {
                weight = 0.0
                print(weight)
                toast(getString(R.string.error))
            }
            setWeight()
        }
    }

    private fun setCalculate() {
        tvResult.text = "0"
        button_calulate.setOnClickListener {

            val result = weight / (height * height)

            if (height == 0.0 && weight == 0.0) {
                toast(getString(R.string.error))
            } else {

                height = 0.0
                weight = 0.0
                tvWeight.text = weight.toString()
                tvHeight.text = weight.toString()
                tvResult.text = result.toString().format(0.0)
            }
        }
    }
}

