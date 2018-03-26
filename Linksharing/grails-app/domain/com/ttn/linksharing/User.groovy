package com.ttn.linksharing
//
/*
    Email should be unique, email type, not null, not blank
    Password should be not null, not blank and minimum 5 charactes
    FirstName,LastName shoule not be null and not blank
    Photo, Admin and Active field can be null
    Write test cases for validating user (including username and email uniqueness)

*/

class User {

    String email
    String userName
    String password
    String firstName
    String lastName
    byte photo
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated

   // String name
    //List<Topic> topics

   // static transients = ['name']
    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,resourceRating:ResourceRating,readingItems:ReadingItem]/*,subscriptions:Subscription,resources:Resource*/

    static constraints = {
        email(unique: true,email: true,blank: false,nullable: false)
        userName(unique: true,blank: false,nullable: false)
        password(blank: false,nullable: false,minSize: 5)
        firstName(blank: false,nullable: false)
        lastName(blank: false,nullable: false)
        photo(nullable:true,sqlType:'longBlob')
        admin(nullable:true)

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
