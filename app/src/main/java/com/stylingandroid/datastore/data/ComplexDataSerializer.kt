package com.stylingandroid.datastore.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.stylingandroid.datastore.security.Crypto
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ComplexDataSerializer(private val crypto: Crypto) :
    Serializer<ComplexData> {

    override val defaultValue: ComplexData = ComplexData()

    override suspend fun readFrom(input: InputStream): ComplexData {
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

    override suspend fun writeTo(t: ComplexData, output: OutputStream) {
        crypto.encrypt(ComplexData.ADAPTER.encode(t), output)
    }
}
