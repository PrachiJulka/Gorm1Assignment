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

      /*  User user=new User(userName: "abc",firstName: "a",lastName: "def",photo: 123,active:true,admin:false,password: "abc123",email: "abc@gmail.com" )
        user.validate()
        user.save()*/
          }
    boolean createUsers(){


        //admin
        if(User.count()==0) {
            User admin = new User(email: "admin@gmail.com", password: "admin@123", firstName: "admin", lastName: "portal", userName: 'adminPortal', photo: 121, admin: true, active: true)
            admin.validate()
            if (admin.hasErrors() == true) {
                log.error("error: ${admin.errors.getAllErrors()}")
                admin.save(flush: true)
                // validate(admin)
                return false
            }

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

    boolean createTopics() {

        if (Topic.count() == 0) {
            User normal = User.findByUserName("PrachiJulka")

            Topic topic = new Topic(name: "BigData", createdBy: normal, visibility: Visibility.PUBLIC)
            normal.addToTopics(topic)

            Topic topic1 = new Topic(name: "Java", createdBy: normal, visibility: Visibility.PRIVATE)
            normal.addToTopics(topic1)

            Topic topic2 = new Topic(name: "nodeJs", createdBy: normal, visibility: Visibility.PUBLIC)
            normal.addToTopics(topic2)

            Topic topic3 = new Topic(name: "AngularJs", createdBy: normal, visibility: Visibility.PRIVATE)
            normal.addToTopics(topic3)

            Topic topic4 = new Topic(name: "MachineLearning", createdBy: normal, visibility: Visibility.PUBLIC)
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
        void createResource(){

            if(Resource.count()==0) {

                List<Topic> topics = Topic.findAll()
                Resource resource = new LinkResource(url: "https://en.wikipedia.org/wiki/Big_data", description: "${topics.get(0).name} url", topic: topics.get(0), user: topics.get(0).createdBy)
                resource.validate()
                log.error("Resource Error: ${resource.errors.allErrors}")
                resource.save()
                Resource resource1 = new LinkResource(url: "https://www.sas.com/en_in/insights/big-data/what-is-big-data.html", description: "${topics.get(0).name} bigdata", topic: topics.get(0), user: topics.get(0).createdBy)
                resource1.validate()
                log.error("Resource Error: ${resource1.errors.allErrors}")
                resource1.save()
                Resource resource2 = new DocumentResource(filePath: "fvnkdfvdk", description: "${topics.get(0).name} cndfbcfefbfer", user: topics.get(0).createdBy, topic: topics.get(0))
                resource2.validate()
                log.error("Resource Error: ${resource2.errors.allErrors}")
                resource2.save()
                Resource resource3 = new DocumentResource(filePath: "nvdjfn", user: topics.get(0).createdBy, description: "${topics.get(0).name} sdns", topic: topics.get(0))
                resource3.validate()
                log.error("Resource Error: ${resource3.errors.allErrors}")
                resource3.save()

                Resource resource4 = new LinkResource(url: "fdvdnjfvnj", description: "${topics.get(0).name} dfvnjdfnv", user: topics.get(1).createdBy, topic: topics.get(1))
                resource4.validate()
                log.error("Resource Error: ${resource4.errors.allErrors}")
                resource4.save()
                Resource resource5 = new LinkResource(url: "cnjdfnjdf", description: "${topics.get(0).name} sdncjdnvjd", user: topics.get(1).createdBy, topic: topics.get(1))
                resource5.validate()
                log.error("Resource Error: ${resource5.errors.allErrors}")
                resource5.save()
                Resource resource6 = new DocumentResource(filePath: "fvnkdfvdk", description: "${topics.get(0).name} cndfbcfefbfer", user: topics.get(1).createdBy, topic: topics.get(1))
                resource6.validate()
                log.error("Resource Error: ${resource6.errors.allErrors}")
                resource6.save()
                Resource resource7 = new DocumentResource(filePath: "nvdjfn", user: topics.get(1).createdBy, description: "${topics.get(0).name} csbhcbshdcbhdb", topic: topics.get(1))
                resource7.validate()
                log.error("Resource Error: ${resource7.errors.allErrors}")
                resource7.save()

                Resource resource8 = new LinkResource(url: "fvjnvf", description: "${topics.get(0).name} dvfnj", user: topics.get(2).createdBy, topic: topics.get(2))
                resource8.validate()
                log.error("Resource Error: ${resource8.errors.allErrors}")
                resource8.save()
                Resource resource9 = new LinkResource(url: "nvjdfnd", description: "${topics.get(0).name} mcksmd", user: topics.get(2).createdBy, topic: topics.get(2))
                resource9.validate()
                log.error("Resource Error: ${resource9.errors.allErrors}")
                resource9.save()
                Resource resource10 = new DocumentResource(filePath: "dlssldsl", description: " ${topics.get(0).name} akoakoa", user: topics.get(2).createdBy, topic: topics.get(2))
                resource10.validate()
                log.error("Resource Error: ${resource10.errors.allErrors}")
                resource10.save()
                Resource resource11 = new DocumentResource(filePath: "dcndncjsl", user: topics.get(2).createdBy, description: "${topics.get(0).name} sdmskdm", topic: topics.get(2))
                resource11.validate()
                log.error("Resource Error: ${resource11.errors.allErrors}")
                resource11.save()

                Resource resource12 = new LinkResource(url: "mkmkmkmk", description: "${topics.get(0).name} sudhusd", user: topics.get(3).createdBy, topic: topics.get(3))
                resource12.validate()
                log.error("Resource Error: ${resource12.errors.allErrors}")
                resource12.save()
                Resource resource13 = new LinkResource(url: "dmfkdmfk", description: "${topics.get(0).name} dncdnvjd", user: topics.get(3).createdBy, topic: topics.get(3))
                resource13.validate()
                log.error("Resource Error: ${resource13.errors.allErrors}")
                resource13.save()
                Resource resource14 = new DocumentResource(filePath: "sdmskdmks", description: "${topics.get(0).name} ldsldl", user: topics.get(3).createdBy, topic: topics.get(3))
                resource14.validate()
                log.error("Resource Error: ${resource14.errors.allErrors}")
                resource14.save()
                Resource resource15 = new DocumentResource(filePath: "dcnsdjncjd", user: topics.get(3).createdBy, description: "${topics.get(0).name} kokokok", topic: topics.get(3))
                resource15.validate()
                log.error("Resource Error: ${resource15.errors.allErrors}")
                resource15.save()

                Resource resource16 = new LinkResource(url: "sdcnsjdncjd", description: "${topics.get(0).name} dscnskdcks", user: topics.get(4).createdBy, topic: topics.get(4))
                resource16.validate()
                log.error("Resource Error: ${resource16.errors.allErrors}")
                resource16.save()
                Resource resource17 = new LinkResource(url: "vfmdkfvm", description: "${topics.get(0).name} dckdkmv", user: topics.get(4).createdBy, topic: topics.get(4))
                resource17.validate()
                log.error("Resource Error: ${resource17.errors.allErrors}")
                resource17.save()
                Resource resource18 = new DocumentResource(filePath: "LAKALLA", description: "${topics.get(0).name} dcnjdnjdfs", user: topics.get(4).createdBy, topic: topics.get(4))
                resource18.validate()
                log.error("Resource Error: ${resource18.errors.allErrors}")
                resource18.save()
                Resource resource19 = new DocumentResource(filePath: "sdkcnskd", user: topics.get(4).createdBy, description: "${topics.get(0).name} ksidksieki", topic: topics.get(4))
                resource19.validate()
                log.error("Resource Error: ${resource19.errors.allErrors}")
                resource19.save()

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
