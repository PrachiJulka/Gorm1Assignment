package com.ttn.linksharing
/*
Add topic domain and its fields with following constraints:

Topic name should be not null, not blank, unique per user
Visibility should be enum and should not be null
Created by should not be null
Write test cases for validating topic
string name
User createdby
datecreated
lastUpated
Enum Visibility
*/

class Topic {

    String name
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    static belongsTo = [ createdBy : User]
    static hasMany = [subscriptions:Subscription, resources:Resource]
    static constraints = {
        name(blank: false, nullable: false, unique: 'createdBy')
        visibility(nullable: false)
    }


}




