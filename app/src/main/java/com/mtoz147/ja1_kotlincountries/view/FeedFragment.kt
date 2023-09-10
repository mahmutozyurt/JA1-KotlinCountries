package com.mtoz147.ja1_kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtoz147.ja1_kotlincountries.R
import com.mtoz147.ja1_kotlincountries.adapter.CountryAdapter
import com.mtoz147.ja1_kotlincountries.databinding.FragmentFeedBinding
import com.mtoz147.ja1_kotlincountries.model.Country
import com.mtoz147.ja1_kotlincountries.viewmodel.FeedViewModel

class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedViewModel
    private var countryAdapter=CountryAdapter(arrayListOf())
    //to create viewmodel to inspect its data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_feed,container,false)
        val view=binding.root

        /*binding.fragmentBtn.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        //it.findNavController().navigate(action)




            *//*binding.editText.text.toString().takeIf { it.isNotBlank() }?.let {
                //to check null safety
                //println(binding.editText.text.toString()) //to check edittext value
                val bundle= bundleOf("countryName" to binding.editText.text.toString())
                 // data is taken from edittext to arguments
               view.findNavController().navigate(R.id.action_feedFragment_to_countryFragment,bundle)
                //data is passed from feed to country fragment
            } ?: kotlin.run { Toast.makeText(activity,"Please enter country",Toast.LENGTH_LONG).show()}*//*

        *//*if(!TextUtils.isEmpty(binding.editText.text.toString())){
                val bundle= bundleOf("countryName" to binding.editText.text.toString())
                // data is taken from edittext to arguments
                it.findNavController().navigate(R.id.action_feedFragment_to_countryFragment,bundle) //view is changed
            }else{
                Toast.makeText(activity,"Please enter country",Toast.LENGTH_LONG).show()
            }*//*

        }*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        binding.countryList.layoutManager=LinearLayoutManager(context)
        //It will enable us to use the layout like the one in the 'item_country'.

        binding.countryList.adapter=countryAdapter


    }
    fun observeLiveData(){
        viewModel.countries.observe(this, Observer {countries->
        countries?.let {
            binding.countryList.visibility=View.VISIBLE
            countryAdapter.updateCountryList(countries)
        }

        })


    }


}