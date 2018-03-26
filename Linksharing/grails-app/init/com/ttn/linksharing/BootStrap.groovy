package com.ttn.linksharing
/*/*
Add createResources method which create 2 link resource and 2 document resource in each topic
        */

class BootStrap {

    def init = { servletContext ->
        createUsers()
        createTopics()
        createResource()
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

            List<Topic> topics=Topic.findAll()
            Resource resource=new LinkResource(url: "https://en.wikipedia.org/wiki/Big_data", description: "Bigdata url",topic:topics.get(0),user:topics.get(0).createdBy)
            resource.save()
            Resource resource1=new LinkResource(url:"https://www.sas.com/en_in/insights/big-data/what-is-big-data.html",description: "bigdata",topic:topics.get(0),user: topics.get(0).createdBy)
            resource1.save()
            Resource resource2 =new DocumentResource(filePath: "fvnkdfvdk",description: "cndfbcfefbfer", user:topics.get(0).createdBy,topic:topics.get(0))
            resource2.save()
            Resource resource3 =new DocumentResource(filePath: "nvdjfn",user:topics.get(0).createdBy,description:"csbhcbshdcbhdb",topic:topics.get(0))
            resource3.save()

            Resource resource4=new LinkResource(url:"fdvdnjfvnj",description: "dfvnjdfnv",user:topics.get(1).createdBy,topic:topics.get(1))
            resource4.save()
            Resource resource5=new LinkResource(url:"cnjdfnjdf",description:"sdncjdnvjd",user:topics.get(1).createdBy,topic:topics.get(1))
            resource5.save()
            Resource resource6 =new DocumentResource(filePath: "fvnkdfvdk",description: "cndfbcfefbfer", user:topics.get(1).createdBy,topic:topics.get(1))
            resource6.save()
            Resource resource7 =new DocumentResource(filePath: "nvdjfn",user:topics.get(1).createdBy,description:"csbhcbshdcbhdb",topic:topics.get(1))
            resource7.save()

            Resource resource8=new LinkResource(url:"fvjnvf",description: "dvfnj",user:topics.get(2).createdBy,topic:topics.get(2))
            resource8.save()
            Resource resource9=new LinkResource(url:"nvjdfnd",description:"mcksmd",user:topics.get(2).createdBy,topic:topics.get(2))
            resource9.save()
            Resource resource10 =new DocumentResource(filePath: "dlssldsl",description: "akoakoa", user:topics.get(2).createdBy,topic:topics.get(2))
            resource10.save()
            Resource resource11 =new DocumentResource(filePath: "dcndncjsl",user:topics.get(2).createdBy,description:"sdmskdm",topic:topics.get(2))
            resource11.save()

            Resource resource12=new LinkResource(url:"mkmkmkmk",description: "sudhusd",user:topics.get(3).createdBy,topic:topics.get(3))
            resource12.save()
            Resource resource13=new LinkResource(url:"dmfkdmfk",description:"dncdnvjd",user:topics.get(3).createdBy,topic:topics.get(3))
            resource13.save()
            Resource resource14 =new DocumentResource(filePath: "sdmskdmks",description: "ldsldl", user:topics.get(3).createdBy,topic:topics.get(3))
            resource14.save()
            Resource resource15 =new DocumentResource(filePath: "dcnsdjncjd",user:topics.get(3).createdBy,description:"kokokok",topic:topics.get(3))
            resource15.save()

            Resource resource16=new LinkResource(url:"sdcnsjdncjd",description: "dscnskdcks",user:topics.get(4).createdBy,topic:topics.get(4))
            resource16.save()
            Resource resource17=new LinkResource(url:"vfmdkfvm",description:"dckdkmv",user:topics.get(4).createdBy,topic:topics.get(4))
            resource17.save()
            Resource resource18 =new DocumentResource(filePath: "LAKALLA",description: "dcnjdnjdfs", user:topics.get(4).createdBy,topic:topics.get(4))
            resource18.save()
            Resource resource19 =new DocumentResource(filePath: "sdkcnskd",user:topics.get(4).createdBy,description:"ksidksieki",topic:topics.get(4))
            resource19.save()




        }


    def destroy = {
    }
}
