package com.bou.challenges

import com.bou.challenges.TemperatureResponse
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

@Secured('ROLE_ADMIN')
class TemperatureController {

    TemperatureService temperatureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond temperatureService.list(params), model:[temperatureCount: temperatureService.count()]
    }

    def show(Long id) {
        respond temperatureService.get(id)
    }

    def create() {
        respond new Temperature(params)
    }

    def convert(Temperature temperature) {
        if (temperature == null) {
            notFound()
            return
        }

        try {
//            temperature.getProperty()
//            temperature.getVal()
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//
//            MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<String, String>();
//            uriVariables.add("property", temperature.getProperty());
//            uriVariables.add("val", temperature.getVal());
//
//            HttpEntity<?> entity = new HttpEntity<>(uriVariables,headers);

            String req = "https://www.q88.com/WS/Q88WSInternal.asmx/ConvertTemperature?property=" + temperature.getProperty() + "&val=" + temperature.getVal();

            println("API request: " + req);

            String getResult = new URL(req).text
            println("API response: " + getResult);

            def list = new XmlSlurper().parseText(getResult)

            println("XML List Result: " + list)

            println "Celsius: ${list.Celsius}"
            println "Fahrenheit: ${list.Fahrenheit}"

            TemperatureResponse temperatureResponse = new TemperatureResponse(celsius: list.Celsius, fahrenheit: list.Fahrenheit)
            [temperatureResponse:temperatureResponse]

        } catch (ValidationException e) {
            respond temperature.errors, view:'create'
            return
        }

    }

    def edit(Long id) {
        respond temperatureService.get(id)
    }

    def update(Temperature temperature) {
        if (temperature == null) {
            notFound()
            return
        }

        try {
            temperatureService.save(temperature)
        } catch (ValidationException e) {
            respond temperature.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'temperature.label', default: 'Temperature'), temperature.id])
                redirect temperature
            }
            '*'{ respond temperature, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        temperatureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'temperature.label', default: 'Temperature'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'temperature.label', default: 'Temperature'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
