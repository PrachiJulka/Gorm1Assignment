package com.ttn.linksharing
/*
Add createTopics method in bootstrap*/


class BootStrap {

    def init = { servletContext ->
       createUsers()
          }
    void createUsers(){


        //admin
        if(User.count()==0) {
            User admin = new User(email: "admin@gmail.com", password: "admin@123", firstName: "admin", lastName: "portal", userName: 'adminPortal', photo: 121, admin: true, active: true)
            admin.validate()
            log.error("error: ${admin.errors.getAllErrors()}")
            admin.save(flush: true)
            if(admin.errors.hasErrors()==false)
                log.info("Admin Saved Successfully")

            //normal
            User normal = new User(email: "prachijulka@gmail.com", password: "admin@123", firstName: "Prachi", lastName: "Julka", userName: 'PrachiJulka', photo: 122, admin: false, active: true)
            normal.validate()
            log.error("error: ${normal.errors.getFieldErrors()}")
            normal.save(flush: true)
            if(normal.errors.hasErrors()==false)
                log.info("Normal User Saved Successfully")
        }
    }


   void createTopic(){

     
    }
    def destroy = {
    }
}
