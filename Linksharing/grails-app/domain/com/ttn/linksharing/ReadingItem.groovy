package com.ttn.linksharing

class ReadingItem {

    Boolean isRead

    static belongsTo = [user:User,resource:Resource]

    static constraints = {
        isRead nullable: false
        user nullable: false, unique: 'resource'
        resource nullable: false


    }
}
