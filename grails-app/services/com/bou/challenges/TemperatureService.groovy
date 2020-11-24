package com.bou.challenges

import grails.gorm.services.Service

@Service(Temperature)
interface TemperatureService {

    Temperature get(Serializable id)

    List<Temperature> list(Map args)

    Long count()

    void delete(Serializable id)

    Temperature save(Temperature temperature)

}