package com.ttn.linksharing
/*
5 topics per user needs to be created if Topic count is 0
*/

class BootStrap {

    def init = { servletContext ->
        createUsers()

        createTopics()
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

    void createTopics(){

        if(Topic.count()==0)
        {
        User normal=User.findByUserName("PrachiJulka")

        Topic topic=new Topic(name: "BigData", createdBy: normal,visibility: Visibility.PUBLIC)
        normal.addToTopics(topic)

            Topic topic1=new Topic(name: "Java",createdBy: normal,visibility: Visibility.PRIVATE)
            normal.addToTopics(topic1)

            Topic topic2=new Topic(name: "nodeJs",createdBy: normal,visibility: Visibility.PUBLIC)
            normal.addToTopics(topic2)

            Topic topic3=new Topic(name: "AngularJs", createdBy: normal,visibility: Visibility.PRIVATE)
            normal.addToTopics(topic3)

            Topic topic4=new Topic(name: "MachineLearning",createdBy: normal,visibility: Visibility.PUBLIC)
            normal.addToTopics(topic4)


            topic.save()
            topic1.save()
            topic2.save()
            topic3.save()
            topic4.save()

        }

    }
    def destroy = {
    }
}
