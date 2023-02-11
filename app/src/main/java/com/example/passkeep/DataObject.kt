package com.example.passkeep


object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(website: String, email: String , password: String) {
        listdata.add(CardInfo(website, email ,password))
    }

    fun getAllData(): List<CardInfo> {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }

    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos:Int,website:String,email:String,password: String)
    {
        listdata[pos].website=website
        listdata[pos].email=email
        listdata[pos].password=password
    }

}