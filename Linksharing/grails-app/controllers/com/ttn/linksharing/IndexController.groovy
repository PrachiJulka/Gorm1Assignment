package com.ttn.linksharing

class IndexController {

    def index() {
//        log.info 'from log info'
        //log.warn 'from log warn'
//        log.println("hi")
//        log.trace('Hello')

        redirect(action:"/")
//render "hi"


    }

    def index1(){
        render "prachi"
    }


    def index2(){
        redirect(action: "index1" ,id:"praci")
    }
}
