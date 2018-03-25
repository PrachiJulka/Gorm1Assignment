package com.ttn.linksharing
/*
Creator of topic should automatically be subscribed to topic (Use after insert event of topic)
*/

class BootStrap {

    def init = { servletContext ->
        if(!createUsers())
            log.error("Error in users creation")
        else
        log.error("Users Created Successfully")

        createTopics()
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

    boolean createTopics(){

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

            topic.validate()
            log.error("Topic ${topic.errors.getFieldErrors()}")
            topic.save()
            topic1.validate()
            log.error("Topic ${topic1.errors.getFieldErrors()}")
            topic1.save()
            topic2.validate()
            log.error("Topic ${topic2.errors.getFieldErrors()}")
            topic2.save()
            topic3.validate()
            log.error("Topic ${topic3.errors.getFieldErrors()}")
            topic3.save()
            topic4.validate()
            log.error("Topic ${topic4.errors.getFieldErrors()}")
            topic4.save()

        }

    }
    def destroy = {
    }
}
