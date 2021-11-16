package com.rushana.magicball

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.rushana.magicball.databinding.HumanItemBinding

class HumanAdapter(private val humanList: List<Human>): RecyclerView.Adapter<HumanAdapter.HumanHolder>() {



    class HumanHolder(item: View): RecyclerView.ViewHolder (item) {
        val binding = HumanItemBinding.bind(item)
        fun bind(human: Human) = with (binding){
            positionHuman.text = human.position
            nameHuman.text = human.name


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanHolder {
        val humanListItemView = LayoutInflater.from(parent.context).inflate(R.layout.human_item, parent, false)
        return HumanHolder(humanListItemView)
    }

    override fun onBindViewHolder(holder: HumanHolder, position: Int) {
        holder.bind(humanList[position])
    }

    override fun getItemCount(): Int {
        return humanList.size
    }




}