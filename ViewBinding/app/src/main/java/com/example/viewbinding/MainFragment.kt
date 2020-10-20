package com.example.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbinding.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var fragmentMainBinding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.tvFragmentTitle.text = "안녕 나는 프래그먼트야!"
        return binding.root
    }

    override fun onDestroyView() {
        fragmentMainBinding = null
        super.onDestroyView()
    }
}