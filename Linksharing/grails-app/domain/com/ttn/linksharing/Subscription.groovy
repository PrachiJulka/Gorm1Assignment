package com.ttn.linksharing

class Subscription {
    Date dateCreated
    Seriousness seriousness
    static belongsTo = [topics:Topic,user:User]

    static constraints = {
        seriousness(nullable:false)
        topics(nullable: false, unique:'user')
        user(nullable: false)
    }

}
