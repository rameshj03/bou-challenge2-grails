package com.bou.challenges

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TemperatureServiceSpec extends Specification {

    TemperatureService temperatureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Temperature(...).save(flush: true, failOnError: true)
        //new Temperature(...).save(flush: true, failOnError: true)
        //Temperature temperature = new Temperature(...).save(flush: true, failOnError: true)
        //new Temperature(...).save(flush: true, failOnError: true)
        //new Temperature(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //temperature.id
    }

    void "test get"() {
        setupData()

        expect:
        temperatureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Temperature> temperatureList = temperatureService.list(max: 2, offset: 2)

        then:
        temperatureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        temperatureService.count() == 5
    }

    void "test delete"() {
        Long temperatureId = setupData()

        expect:
        temperatureService.count() == 5

        when:
        temperatureService.delete(temperatureId)
        sessionFactory.currentSession.flush()

        then:
        temperatureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Temperature temperature = new Temperature()
        temperatureService.save(temperature)

        then:
        temperature.id != null
    }
}
