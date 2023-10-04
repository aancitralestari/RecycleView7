package id.citra.recycleview7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.citra.recycleview7.databinding.Content1Binding
import id.citra.recycleview7.model.Content1
import id.citra.recycleview7.model.DataItemType

class Content1Adapter (
    private val viewType: Int,
    private val recyclerItemList: List<Content1>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Content1ViewHolder(private val binding: Content1Binding ) : RecyclerView.ViewHolder(binding.root) {

        fun bindContent1View(content1: Content1) {
            binding.ivIcon1.setImageResource(content1.image)
            binding.tvTeks1.text = content1.content1

        }

    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            DataItemType.CONTENT1 -> {
                val binding = Content1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Content1ViewHolder(binding)
            }
            else -> {
                val binding = Content1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Content1ViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {

            is Content1ViewHolder -> {
                holder.bindContent1View(recyclerItemList[position])
            }
        }
    }
}