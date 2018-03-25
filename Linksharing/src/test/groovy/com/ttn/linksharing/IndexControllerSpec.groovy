package com.ttn.linksharing

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class IndexControllerSpec extends Specification implements ControllerUnitTest<IndexController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            false == false
    }

    def "Test"(){
    when:
        controller.index1()

        then:
        response.contentAsString=="prachi"
    }

    def "Test Index2"(){
        when:
        controller.index2()

        then:
        response.redirectUrl=="/index/index1/"+"praci"
    }
}
