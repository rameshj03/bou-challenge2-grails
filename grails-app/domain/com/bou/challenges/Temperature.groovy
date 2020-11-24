package com.bou.challenges

class Temperature {

    String property
    String val

    static constraints = {
	    property(blank:false)
        val(blank:false)
    }
}
