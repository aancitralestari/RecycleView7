package id.citra.recycleview7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.citra.recycleview7.R
import id.citra.recycleview7.databinding.ChildItemBinding
import id.citra.recycleview7.databinding.Content4Binding
import id.citra.recycleview7.model.Content1
import id.citra.recycleview7.model.Content2
import id.citra.recycleview7.model.Content3
import id.citra.recycleview7.model.Content4
import id.citra.recycleview7.model.Content5
import id.citra.recycleview7.model.DataItem
import id.citra.recycleview7.model.DataItemType

class MainAdapter(
    private val dataItemList: List<DataItem>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    inner class SectionItemViewHolder(private val binding: Content4Binding) : RecyclerView.ViewHolder(binding.root){

        fun bindSectionView(content4: Content4){
            binding.tvLanjut.text = content4.text
        }

    }

    inner class RecyclerItemViewHolder(private val binding: ChildItemBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.rvChild.setHasFixedSize(true)
            binding.rvChild.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }


        fun bindContent1RecyclerView(content1ItemList: List<Content1>) {
            val adapter = Content1Adapter(DataItemType.CONTENT1, content1ItemList)
            binding.rvChild.adapter = adapter
        }

        fun bindContent2RecyclerView(content2ItemList: List<Content2>) {
            val adapter = Content2Adapter(DataItemType.CONTENT2, content2ItemList)
            binding.rvChild.adapter = adapter
        }

        fun bindContent5RecyclerView(content5ItemList: List<Content5>) {
            val adapter = Content5Adapter(DataItemType.CONTENT5, content5ItemList)
            binding.rvChild.adapter = adapter
        }

        fun bindContent3RecyclerView(content3ItemList: List<Content3>) {
            val adapter = Content3Adapter(DataItemType.CONTENT3, content3ItemList)
            binding.rvChild.adapter = adapter
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when(dataItemList[position].viewType) {
            DataItemType.CONTENT4 ->
                R.layout.content4
            else ->
                R.layout.child_item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.content4 -> {
                val binding = Content4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                SectionItemViewHolder(binding)
            }

            else -> {
                val binding = ChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }

        }
    }

    override fun getItemCount(): Int = dataItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SectionItemViewHolder -> {
                dataItemList[position].content4List?.let { holder.bindSectionView(it) }
            }
            else -> {
                when (dataItemList[position].viewType) {
                    DataItemType.CONTENT1 -> {
                        dataItemList[position].content1List?.let {
                            (holder as RecyclerItemViewHolder).bindContent1RecyclerView(it)
                        }
                    }
                    DataItemType.CONTENT2 -> {
                        dataItemList[position].content2List?.let {
                            (holder as RecyclerItemViewHolder).bindContent2RecyclerView(it)
                        }
                    }
                    DataItemType.CONTENT3 -> {
                        dataItemList[position].content3List?.let {
                            (holder as RecyclerItemViewHolder).bindContent3RecyclerView(it)
                        }
                    }
                    DataItemType.CONTENT5 -> {
                        dataItemList[position].content5List?.let {
                            (holder as RecyclerItemViewHolder).bindContent5RecyclerView(it)
                        }
                    }
                }
            }
        }
    }
}