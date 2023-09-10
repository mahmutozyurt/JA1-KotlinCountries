package com.mtoz147.ja1_kotlincountries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mtoz147.ja1_kotlincountries.databinding.FragmentCountryBinding


class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)
        //val countryInfo=requireArguments()?.getString("countryName")
        val countryInfo=arguments?.getString("countryName")
        binding.showTxt.text=countryInfo.toString()
        //to get info from
        return binding.root
    }


}