package com.aiden.playwithfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aiden.playwithfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isNewInput = true

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
    }

    fun numberEvent(view: View) {

        if (isNewInput) {
            setTextTOEditText("")
        }
        isNewInput = false

        var buttonClicked = binding.tvCalculator.text.toString()
        var selectedBtn = view as Button

        when (selectedBtn.id) {
            binding.btnDOt.id -> {
                buttonClicked += "."
            }
            binding.btnEight.id -> {
                buttonClicked += "8"
            }
            binding.btnNine.id -> {
                buttonClicked += "9"
            }
            binding.btnOne.id -> {
                buttonClicked += "1"
            }
            binding.btnTwo.id -> {
                buttonClicked += "2"
            }
            binding.btnThree.id -> {
                buttonClicked += "3"
            }
            binding.btnFour.id -> {
                buttonClicked += "4"
            }
            binding.btnFive.id -> {
                buttonClicked += "5"
            }
            binding.btnSix.id -> {
                buttonClicked += "6"
            }
            binding.btnSeven.id -> {
                buttonClicked += "7"
            }
            binding.btnZero.id -> {
                buttonClicked += "0"
            }
            binding.btnAddSub.id -> {
                buttonClicked = "-$buttonClicked"
            }

            binding.btnAc.id -> {
                buttonClicked = ""
            }
        }

        setTextTOEditText(buttonClicked)
    }


    private fun setTextTOEditText(text: String) {
        binding.tvCalculator.setText(text)
    }

    fun operaterEvent(view: View) {
        val selectedBtn = view as Button
        when (selectedBtn.id) {
            binding.btnAdd.id, binding.btnDivide.id, binding.btnMultiplay.id, binding.btnSubtract.id -> {
                binding.tvCalculator.setText("${binding.tvCalculator.text}${selectedBtn.text}")
                isNewInput = false
            }

        }
    }


    fun equalTO(view: View) {
        with(binding.tvCalculator.text.toString()) {
            when {
                contains('+') -> {
                    val split = binding.tvCalculator.text.toString().split('+')
                    val sum = split[0].toDouble() + split[1].toDouble()
                    binding.tvCalculator.setText(sum.toString())
                }
                contains('-') -> {
                    val split = binding.tvCalculator.text.toString().split('-')
                    val sub = split[0].toDouble() - split[1].toDouble()
                    binding.tvCalculator.setText(sub.toString())
                }
                contains('*') -> {
                    val split = binding.tvCalculator.text.toString().split('*')
                    val mul = split[0].toDouble() * split[1].toDouble()
                    binding.tvCalculator.setText(mul.toString())
                }
                contains('/') -> {
                    val split = binding.tvCalculator.text.toString().split('/')
                    if (split[1].toInt() != 0) {
                        val divide = split[0].toDouble() / split[1].toDouble()
                        binding.tvCalculator.setText(divide.toString())
                    }
                }
            }
        }
    }


}


