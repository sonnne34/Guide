package com.template

data class Model(
    var sectionName: String,
    var articles: HashMap<String, ArticlesItemsModel> = HashMap()
) {
}