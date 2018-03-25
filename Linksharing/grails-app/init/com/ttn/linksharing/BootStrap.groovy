package com.ttn.linksharing
/*
Use failOnError and flush true for persisting users.*/


class BootStrap {

    def init = { servletContext ->
        if(!createUsers())
            println("Error in users creation")
        else
        println("Users Created Successfully")

          }
    boolean createUsers(){

        //admin
        User admin=new User(email: "admin@gmail.com",password: "admin@123",firstName: "admin",lastName: "portal",userName:'adminPortal' , photo: 121,admin:true,active:true)
        admin.validate()
        admin.save(flush:true)
        if(admin.hasErrors()==true)
            return false
        //normal
        User normal=new User(email: "prachijulka@gmail.com",password: "admin@123",firstName: "Prachi",lastName: "Julka",userName:'PrachiJulka',photo: 122,admin:false,active:true)
        normal.validate()
         normal.save(flush:true)

        if(normal.hasErrors()==true)
            return false

        return true


    }
    def destroy = {
    }
}
