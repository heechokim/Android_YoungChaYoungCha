package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.modal_bottom_sheet_layout.*

class BottomSheetDialog: BottomSheetDialogFragment() {

    lateinit var bottomSheetButtonClickListener: BottomSheetButtonClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.modal_bottom_sheet_layout, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_button1.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("1번 버튼 눌림!")
            dismiss()
        }

        button_button2.setOnClickListener {
            bottomSheetButtonClickListener.onButtonClicked("2번 버튼 눌림!")
            dismiss()
        }
    }

    interface BottomSheetButtonClickListener{
        fun onButtonClicked(text: String)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            bottomSheetButtonClickListener = context as BottomSheetButtonClickListener
        } catch (e: ClassCastException) {
            Log.d("chohee", "onAttach error")
        }

    }

}


