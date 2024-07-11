package com.example.easydictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easydictionary.databinding.MeningRecylerRowBinding

class MeaningAdapter(private var meaningList: List<Meaning>) : RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {

    class MeaningViewHolder(private val binding: MeningRecylerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(meaning: Meaning){
            binding.partOfSpeechTextview.text = meaning.partOfSpeech
            binding.definitionsTextview.text = meaning.definitions.joinToString("\n\n"){
                val currentIndex = meaning.definitions.indexOf(it)
                (currentIndex+1).toString()+". "+it.definition.toString()
            }
            if (meaning.synonyms.isEmpty()){
                binding.synonymsTitleTextview.visibility = View.GONE
                binding.synonymsTextview.visibility = View.GONE
            }else{
                binding.synonymsTitleTextview.visibility = View.GONE
                binding.synonymsTextview.visibility = View.GONE
                binding.synonymsTextview.text = meaning.synonyms.joinToString(", ")
            }
            if (meaning.antonyms.isEmpty()){
                binding.antonymsTitleTextview.visibility = View.GONE
                binding.antonymsTextview.visibility = View.GONE
            }else{
                binding.antonymsTitleTextview.visibility = View.GONE
                binding.antonymsTextview.visibility = View.GONE
                binding.antonymsTextview.text = meaning.antonyms.joinToString(", ")
            }
        }
    }


    fun updateNewData(newMeaningList: List<Meaning>){
        meaningList = newMeaningList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val binding = MeningRecylerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MeaningViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return meaningList.size
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
       holder.bind(meaningList[position])
    }
}