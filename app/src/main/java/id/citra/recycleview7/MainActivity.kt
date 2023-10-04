package id.citra.recycleview7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.citra.recycleview7.adapter.MainAdapter
import id.citra.recycleview7.databinding.ActivityMainBinding
import id.citra.recycleview7.model.Content1
import id.citra.recycleview7.model.Content2
import id.citra.recycleview7.model.Content3
import id.citra.recycleview7.model.Content4
import id.citra.recycleview7.model.Content5
import id.citra.recycleview7.model.DataItem
import id.citra.recycleview7.model.DataItemType

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var listData : ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvIndex.setHasFixedSize(true)
        binding.rvIndex.layoutManager = LinearLayoutManager(this)

        listData = ArrayList()
        allData()

        val adapter = MainAdapter(listData)
        binding.rvIndex.adapter = adapter
    }

    private fun allData() {
        val content1Data = ArrayList<Content1>()
        content1Data.add(Content1(R.drawable.icon1, "Coins"))
        content1Data.add(Content1(R.drawable.icon2, "Langganan" ))
        content1Data.add(Content1(R.drawable.icon3, "Gold"))

        val content2Data = ArrayList<Content2>()
        content2Data.add(Content2(R.drawable.bannertokped1))
        content2Data.add(Content2(R.drawable.bannertokped2))
        content2Data.add(Content2(R.drawable.bannertokped3))

        val content3Data = ArrayList<Content3>()
        content3Data.add(Content3(R.drawable.ic_menu1, "Lihat Semua"))
        content3Data.add(Content3(R.drawable.ic_menu2, "Diskon 50%"))
        content3Data.add(Content3(R.drawable.ic_menu3, "Top-up & Tagihan"))
        content3Data.add(Content3(R.drawable.ic_menu4, "Travel dan Entertainment"))
        content3Data.add(Content3(R.drawable.ic_menu5, "Promo Hari ini"))
        content3Data.add(Content3(R.drawable.ic_menu6, "Go Food"))

        val content5Data = ArrayList<Content5>()
        content5Data.add(Content5(R.drawable.top1, "Furniture"))
        content5Data.add(Content5(R.drawable.top2, "Gadget"))
        content5Data.add(Content5(R.drawable.top3, "Food"))
        content5Data.add(Content5(R.drawable.top4, "Holiyay"))

        listData.add(DataItem(DataItemType.CONTENT1, content1Data, content2Data, content3Data, content5Data))
        listData.add(DataItem(DataItemType.CONTENT2, content1Data, content2Data, content3Data, content5Data))
        listData.add(DataItem(DataItemType.CONTENT3, content1Data, content2Data, content3Data, content5Data))
        listData.add(DataItem(DataItemType.CONTENT4, Content4("Lanjut")))
        listData.add(DataItem(DataItemType.CONTENT5, content1Data, content2Data, content3Data, content5Data))
    }
}