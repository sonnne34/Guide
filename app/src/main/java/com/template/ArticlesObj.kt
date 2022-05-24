package com.template

object ArticlesObj {

    var sectionsModel : ArrayList<SectionsModel> = ArrayList()
//    var listeners: ArrayList<EventListeners> = ArrayList()

    fun addSection(item : SectionsModel){
        var boolean = true
        for(i in sectionsModel){
            if(i.sectionName == item.sectionName){
                boolean = false
            }
        }
        if (boolean){
            sectionsModel.add(item)
        }
    }
}