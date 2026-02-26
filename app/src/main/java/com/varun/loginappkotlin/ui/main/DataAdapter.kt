package com.varun.loginappkotlin.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varun.loginappkotlin.R
import com.varun.loginappkotlin.data.remote.response.DataList
import com.varun.loginappkotlin.databinding.AdapterDataBinding
import com.varun.loginappkotlin.utils.common.Toaster

//import com.varun.loginappkotlin.ui.details.ScoreCardDetailsActivity

class DataAdapter(
    val context: Context, private var dataList: ArrayList<DataList?>
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): DataViewHolder {
        val binding = AdapterDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DataViewHolder, position: Int
    ) {
        try {
            holder.binding.firstname.text = dataList[position]?.firstname
            holder.binding.lastname.text = dataList[position]?.lastname
            holder.binding.email.text = dataList[position]?.email


//            holder.binding.textTypeStatus.text =
//                dataList[position]?.matchType.plus(" | ").plus(dataList[position]?.status)
//            holder.binding.textVenueDate.text =
//                dataList[position]?.venue.plus(" | ").plus(dataList[position]?.date)

//            Glide.with(context).load(dataList[position]?.avatar).placeholder(
//                R.mipmap.ic_launcher
//            ).into(holder.binding.imgTeam1)
//            holder.binding.tvTeam1Shortname.text = dataList[position]?.teamInfo?.get(0)?.shortname

//

            holder.itemView.setOnClickListener {
                val id = dataList[position]?.id.toString()
                Toaster.show(context,id)
//                val intent = ScoreCardDetailsActivity.newIntent(
//                    context,
//                    id
//                )
//                context.startActivity(intent)
            }
        } catch (e: Exception) {
            e.stackTrace
        }

    }


    fun onAddItems(list: ArrayList<DataList?>) {
        this.dataList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class DataViewHolder(var binding: AdapterDataBinding) : RecyclerView.ViewHolder(binding.root) {}

}

