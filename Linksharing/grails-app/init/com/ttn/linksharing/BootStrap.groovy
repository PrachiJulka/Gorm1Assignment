package com.ttn.linksharing
/*
Use failOnError and flush true for persisting users.*/


class BootStrap {

    def init = { servletContext ->
      createUsers()

          }
    void createUsers(){

        //admin
        User admin=new User(email: "admin@gmail.com",password: "admin@123",firstName: "admin",lastName: "portal",userName:'adminPortal' , photo: 121,admin:true,active:true)
        admin.validate()
        admin.save(failOnError:true)
      
        //normal
        User normal=new User(email: "prachijulka@gmail.com",password: "admin@123",firstName: "Prachi",lastName: "Julka",userName:'PrachiJulka',photo: 122,admin:false,active:true)
        normal.validate()
        normal.save(failOnError:true)



    }
    def destroy = {
    }
}
