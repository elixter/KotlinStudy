package com.elixter.kopring.service.member

import org.slf4j.LoggerFactory
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object PasswordEncoder {

    fun sha256(plainText: String): String {
        val md: MessageDigest = try {
            MessageDigest.getInstance("SHA-256")
        } catch (e: NoSuchAlgorithmException) {
            throw e
        }
        md.update(plainText.toByte())

        return byteToHex(md.digest())
    }

    private fun byteToHex(byteArray: ByteArray): String {
        val builder = StringBuilder()
        for (b in byteArray) {
            builder.append(b)
        }

        return builder.toString()
    }
}