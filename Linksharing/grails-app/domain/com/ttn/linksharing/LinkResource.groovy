package com.ttn.linksharing
//Link Resource should have valid url
class LinkResource extends Resource {

    String url

    static constraints = {
        url(url: true,nullable:false,blank: false)
    }
}
