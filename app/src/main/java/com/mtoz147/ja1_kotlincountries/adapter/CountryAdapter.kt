package com.mtoz147.ja1_kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mtoz147.ja1_kotlincountries.R
import com.mtoz147.ja1_kotlincountries.databinding.ItemCountryBinding
import com.mtoz147.ja1_kotlincountries.model.Country

class CountryAdapter(val countryList:ArrayList<Country>) :RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    class CountryViewHolder(var binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

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
        holder.binding.name.text=countryList[position].countryName
        holder.binding.region.text=countryList[position].countryRegion
    }
    //swipe refresh func. has been applied.
    fun updateCountryList(newCountryList:List <Country>){
        countryList.clear() //updated countrylist content is cleared
        countryList.addAll(newCountryList) // this new list is replaced old one after "swipe refresh" action.
        notifyDataSetChanged()// to use refresh the adapter
    }



}