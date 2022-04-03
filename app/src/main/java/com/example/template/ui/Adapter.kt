package com.example.template.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.databinding.ListItemBinding
import com.example.template.datasource.db.SomeData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Adapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER: Int = 0
    private val TYPE_ITEM: Int = 1
    private val TYPE_FOOTER: Int = 2
    private val list: MutableList<SomeData> = ArrayList()
    lateinit var fistViewModel: FistViewModel

    fun setData(newList: List<SomeData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolderItem(private val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.getRoot()) {
        fun bind(someData: SomeData) {
            itemBinding.someData = someData
            itemBinding.executePendingBindings()
        }
    }

    inner class ViewHolderHeader(val viewHeader: View) : RecyclerView.ViewHolder(viewHeader)

    inner class ViewHolderFooter(val viewFooter: View) : RecyclerView.ViewHolder(viewFooter)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // if use footer or header need return ViewHolder"TYPE" via different viewType
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        val vh = ViewHolderItem(itemBinding)
        itemBinding.root.setOnLongClickListener() {
            val position: Int = vh.adapterPosition
            fistViewModel.delete(list[position])
            true
        }
        return vh
    }

    override fun getItemCount(): Int {
        //change count if used footer or header
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderItem) {
            holder.bind(list[position])
        }

    }

    // need use method if used footer or header
// override fun getItemViewType(position: Int): Int {
//        if (position == list.size){
//            return TYPE_FOOTER
//        }
//        return super.getItemViewType(position)
//  }

}

