package com.example.app.util

object AppUtil {

    /**
     * 入力された文字のひらがなをカタカナに変換する
     */
    fun convertHiraganaToKatakana(str: String): String {
        val hiraganaStart = 0x3041
        val katakanaStart = 0x30A1
        val conversionDiff = katakanaStart - hiraganaStart

        return str.map { char ->
            if (char in '\u3041'..'\u3096') {
                char + conversionDiff
            } else {
                char
            }
        }.joinToString("")
    }
}