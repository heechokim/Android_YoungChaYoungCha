package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BottomSheetDialog.BottomSheetButtonClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_showModal.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog()
            bottomSheetDialog.show(supportFragmentManager, "exampleBottomSheet")
        }
    }

    override fun onButtonClicked(text: String) {
        textView_clickedItem.text = text
    }
}
