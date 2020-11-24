package com.bou.challenges

class TemperatureResponse {

    BigDecimal celsius
    BigDecimal fahrenheit

    static constraints = {
	    celsius(blank:false, scale: 1)
        fahrenheit(blank:false, scale: 1)
    }
}
