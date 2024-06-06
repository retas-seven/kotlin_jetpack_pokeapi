package com.example.app.test_util

import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter

class NullBlankConverter : SimpleArgumentConverter() {
    override fun convert(source: Any?, targetType: Class<*>): Any? {
        if (source == "NULL" || source == "null") {
            return null
        }
        if (source == "''") {
            return ""
        }
        return source
    }
}

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@ConvertWith(NullBlankConverter::class)
annotation class ConvCsvSource