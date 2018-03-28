package com.ttn.linksharing
/*
Use failOnError and flush true for persisting users.*/


class BootStrap {

    def init = { servletContext ->
      createUsers()

          }
     void createUsers(){


        //admin
     
            User admin = new User(email: "admin@gmail.com", password: DefaultPassword.PASSWORD, firstName: "admin", lastName: "portal", userName: 'adminPortal', photo: 121, admin: true, active: true)
            if(admin.save(failOnError:true)){
                log.info("Admin Saved Successfully")
            }
            else {
                log.error("error: ${admin.errors.getAllErrors()}")
            }

            //normal
            User normal = new User(email: "prachijulka@gmail.com", password: DefaultPassword.PASSWORD, firstName: "Prachi", lastName: "Julka", userName: 'PrachiJulka', photo: 122, admin: false, active: true)
            if(normal.save(failOnError:true)){
                log.info("Normal User Saved Successfully")
            }
            else {
                log.error("error: ${normal.errors.getFieldErrors()}")
            }

        }
    
    
    def destroy = {
    }
}
