package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        false == false
    }

    def "Email address of user should be unique"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1= new User(email: email,userName:"prachi",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1


    }

    def "Email address of user should be in valid format"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1= new User(email: "prachijulka",userName:"prachi",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1




    }

    def "Email address of user should not be blank"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1= new User(email:"",userName:"prachi",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1
     }
    def "Email address of user should not be null"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1= new User(email:null,userName:"prachi",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1
    }

    def "Passowrd of a user should be minimum of 5 characters"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1= new User(email:"nirja@gmail.com",userName:"prachi",password:"90s", firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('password') == 1
        user1.errors.allErrors.size() == 1
    }
    def "Password of a user should not be blank or null"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1= new User(email:"nirja@gmail.com",userName:"nirja",password:"", firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('password') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2= new User(email:"nirja1@gmail.com",userName:"nirja1",password:null, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)

        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('password') == 1
        user2.errors.allErrors.size() == 1
    }

    def "Username of user should be unique"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1= new User(email: "nirja@gmail.com",userName:"prachiJ",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('userName') == 1
        user1.errors.allErrors.size() == 1


    }

    def "Username of user should not be blank or null"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1= new User(email: "nirja@gmail.com",userName:"",password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('userName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2= new User(email: "nirja@gmail.com",userName:null,password:password, firstName: "Nirja", lastName: "Sharma",admin:false,active:true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('userName') == 1
        user2.errors.allErrors.size() == 1

    }
    def "FirstName of user should not be blank or null"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1= new User(email: "nirja@gmail.com",userName:"nirja",password:password, firstName: "", lastName: "Sharma",admin:false,active:true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('firstName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2= new User(email: "nirja1@gmail.com",userName:"nirja1",password:password, firstName: null, lastName: "Sharma",admin:false,active:true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('firstName') == 1
        user2.errors.allErrors.size() == 1

    }



    def "LastName of user should not be blank or null"() {
        setup:

        String email = "prachijulka@tothenew.com"
        String password = 'p1231'
        User user = new User(email: email,userName:"prachiJ",password:password, firstName: "Prachi", lastName: "Julka",admin:false,active:true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1= new User(email: "nirja@gmail.com",userName:"nirja",password:password, firstName: "Nirja", lastName: "",admin:false,active:true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('lastName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2= new User(email: "nirja1@gmail.com",userName:"nirja1",password:password, firstName: "Nirja", lastName: null,admin:false,active:true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('lastName') == 1
        user2.errors.allErrors.size() == 1

    }

}
