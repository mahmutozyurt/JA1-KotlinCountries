package com.mtoz147.ja1_kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mtoz147.ja1_kotlincountries.R
import com.mtoz147.ja1_kotlincountries.databinding.ItemCountryBinding
import com.mtoz147.ja1_kotlincountries.model.Country
import com.mtoz147.ja1_kotlincountries.util.downloadFromUrl
import com.mtoz147.ja1_kotlincountries.util.placeHolderProgressBar
import com.mtoz147.ja1_kotlincountries.view.FeedFragmentDirections

class CountryAdapter(val countryList:ArrayList<Country>) :RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    class CountryViewHolder(var binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) ,CountryClickListener{
        override fun onCountryClicked(v: View) {
            /*val binding=v.tag as? ItemCountryBinding?:return
            val uuid=binding.country?.uuid?:return*//*
            val uuid=ItemCountryBinding.bind(v).countryUuidText.text.toString().toInt()*/


            val uuid=binding.countryUuidText.text.toString().toInt()
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            action.countryUuid=uuid
            Navigation.findNavController(v).navigate(action)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
    return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        //Data binding changes have been implemented.

        holder.binding.country=countryList[position]
        holder.binding.listener=holder



        /*holder.binding.name.text=countryList[position].countryName
        holder.binding.region.text=countryList[position].countryRegion


        //We are defining what will happen when a view is clicked.
        holder.binding.root.setOnClickListener {
        val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            action.countryUuid=countryList[position].uuid
            it.findNavController().navigate(action)
        }

        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl,
            placeHolderProgressBar(holder.binding.root.context))*/

    }
    //swipe refresh func. has been applied.
    fun updateCountryList(newCountryList:List <Country>){
        countryList.clear() //updated countrylist content is cleared
        countryList.addAll(newCountryList) // this new list is replaced old one after "swipe refresh" action.
        notifyDataSetChanged()// to use refresh the adapter
    }

   /* override fun onCountryClicked(v: View) {
        *
        val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
        action.countryUuid=uuid
        Navigation.findNavController(v).navigate(action)
    }*/


}