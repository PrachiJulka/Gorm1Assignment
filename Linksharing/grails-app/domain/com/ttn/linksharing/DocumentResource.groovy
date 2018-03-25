package com.ttn.linksharing
//Document resource should have filepath
class DocumentResource extends Resource {

    String filePath

    static constraints = {
        filePath(nullable: false,blank: false)
    }
}
