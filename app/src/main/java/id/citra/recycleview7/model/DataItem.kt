package id.citra.recycleview7.model

data class DataItem(val viewType: Int) {
    var content1List : List<Content1>? = null
    var content2List : List<Content2>? = null
    var content3List : List<Content3>? = null
    var content4List : Content4? = null
    var content5List : List<Content5>? = null


    constructor(viewType: Int, content1List: List<Content1>, content2List: List<Content2>, content3List: List<Content3>, content5List: List<Content5>) : this(viewType) {
        this.content1List = content1List
        this.content2List = content2List
        this.content3List = content3List
        this.content5List = content5List
    }

    constructor(viewType: Int, content4: Content4) : this(viewType) {
        this.content4List = content4
    }
}