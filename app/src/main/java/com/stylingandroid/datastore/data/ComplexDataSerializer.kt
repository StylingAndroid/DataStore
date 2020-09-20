package com.stylingandroid.datastore.data

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import com.stylingandroid.datastore.security.Crypto
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ComplexDataSerializer(private val crypto: Crypto) :
    Serializer<ComplexData> {

    override fun readFrom(input: InputStream): ComplexData {
        return if (input.available() != 0) {
            try {

                ComplexData.ADAPTER.decode(crypto.decrypt(input))
            } catch (exception: IOException) {
                throw CorruptionException("Cannot read proto", exception)
            }
        } else {
            ComplexData()
        }
    }

    override fun writeTo(t: ComplexData, output: OutputStream) {
        crypto.encrypt(ComplexData.ADAPTER.encode(t), output)
    }
}
