package com.ttn.linksharing
/*
Users will be created only when there are no records in user table*/


class BootStrap {

    def init = { servletContext ->
        if(!createUsers())
            log.error("Error in users creation")
        else
        log.error("Users Created Successfully")

          }
    boolean createUsers(){


        //admin
        if(User.count()==0) {
            User admin = new User(email: "admin@gmail.com", password: "admin@123", firstName: "admin", lastName: "portal", userName: 'adminPortal', photo: 121, admin: true, active: true)
            admin.validate()
            log.error("error: ${admin.errors.getFieldErrors()}")
            admin.save(flush: true)
            if (admin.hasErrors() == true)
                return false

            //normal
            User normal = new User(email: "prachijulka@gmail.com", password: "admin@123", firstName: "Prachi", lastName: "Julka", userName: 'PrachiJulka', photo: 122, admin: false, active: true)
            normal.validate()

            log.error("error: ${normal.errors.getFieldErrors()}")
            normal.save(flush: true)

            if (normal.hasErrors() == true)
                return false

            return true
        }
        return false


    }
    def destroy = {
    }
}
