package com.ttn.linksharing
/*
Add subscribeTopics for user to subscribe all the topics
 which are not created by user */

class BootStrap {

    def init = { servletContext ->

        createUsers()
        createTopics()
        createResource()
       subscribeTopicsNotCreatedByUser()

     
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

    void createTopics() {
        List<User> userCount = User.getAll()
        userCount.each {

            if (Topic.findAllByCreatedBy(it).size()==0) {
                //User normal = User.findByUserName("PrachiJulka")

                Topic topic = new Topic(name: "BigData", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic)

                Topic topic1 = new Topic(name: "Java", createdBy: it, visibility: Visibility.PRIVATE)
                it.addToTopics(topic1)

                Topic topic2 = new Topic(name: "nodeJs", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic2)

                Topic topic3 = new Topic(name: "AngularJs", createdBy: it, visibility: Visibility.PRIVATE)
                it.addToTopics(topic3)

                Topic topic4 = new Topic(name: "MachineLearning", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic4)

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
    }
        void createResource(){

            if(Resource.count()==0) {

                List<Topic> topics = Topic.getAll()

                topics.each {
                    Resource resource = new LinkResource(url: "https://en.wikipedia.org/wiki/Big_data", description: "${it.name} url", topic: it, user: it.createdBy)
                    resource.validate()
                    log.error("Resource Error: ${resource.errors.allErrors}")
                    resource.save()
                    Resource resource1 = new LinkResource(url: "https://www.sas.com/en_in/insights/big-data/what-is-big-data.html", description: "${it.name} bigdata", topic: it, user:it.createdBy)
                    resource1.validate()
                    log.error("Resource Error: ${resource1.errors.allErrors}")
                    resource1.save()
                    Resource resource2 = new DocumentResource(filePath: "fvnkdfvdk", description: "${it.name} cndfbcfefbfer", user: it.createdBy, topic: it)
                    resource2.validate()
                    log.error("Resource Error: ${resource2.errors.allErrors}")
                    resource2.save()
                    Resource resource3 = new DocumentResource(filePath: "nvdjfn", user: it.createdBy, description: "${it.name} sdns", topic: it)
                    resource3.validate()
                    log.error("Resource Error: ${resource3.errors.allErrors}")
                    resource3.save()

                }

            }


        }  
 void subscribeTopicsNotCreatedByUser(){
       Integer id=1;
        List<User> userCount=User.getAll()

        userCount.each{
            User user=it
            List<Topic> topics=Topic.findAllByCreatedByNotEqual(user)

            topics.each {
               Subscription subscription = new Subscription(seriousness: Seriousness.CASUAL, user: user, topics: it)
               subscription.validate()
               subscription.save()
           }

            id++
        }

    }


    def destroy = {
    }
}
