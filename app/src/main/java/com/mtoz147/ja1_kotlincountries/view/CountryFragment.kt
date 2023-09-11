package com.mtoz147.ja1_kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mtoz147.ja1_kotlincountries.R
import com.mtoz147.ja1_kotlincountries.databinding.FragmentCountryBinding
import com.mtoz147.ja1_kotlincountries.viewmodel.CountryViewModel


class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private lateinit var viewModel: CountryViewModel

    private var countryUuid=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_country,container,false)
        //val countryInfo=requireArguments()?.getString("countryName")
        /*val countryInfo=arguments?.getString("countryName")
        binding.showTxt.text=countryInfo*/
                //to get info from

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom()


        //the other safe args method is used
       arguments?.let {
            countryUuid=CountryFragmentArgs.fromBundle(it).countryUuid
        }
        observeLiveData()
    }
    private fun observeLiveData(){
    viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {country->
        country?.let{
            binding.countryName.text=country.countryName
            binding.countryRegion.text=country.countryRegion
            binding.countryCapital.text=country.countryCapital
            binding.countryCurrency.text=country.countryCurrency
            binding.countryLanguages.text=country.countryLanguages
        }

    })
    }

}