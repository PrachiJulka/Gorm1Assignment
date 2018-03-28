package com.ttn.linksharing

class IndexController {

    def index() {


    //    render(template: 'book_template', collection: Book.list())
        Map map=['abc':20,'bcd':40]
        render(view:"index" ,model: [person:map])
    }


}
