package com.stylingandroid.datastore.data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.stylingandroid.datastore.security.Crypto
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class SecureSimpleDataSerializer(private val crypto: Crypto) :
    Serializer<SimpleData> {

    override val defaultValue: SimpleData = SimpleData()

    override suspend fun readFrom(input: InputStream): SimpleData {
        return if (input.available() != 0) {
            try {
                SimpleData.ADAPTER.decode(crypto.decrypt(input))
            } catch (exception: IOException) {
                throw CorruptionException("Cannot read proto", exception)
            }
        } else {
            SimpleData("")
        }
    }

    override suspend fun writeTo(t: SimpleData, output: OutputStream) {
        crypto.encrypt(SimpleData.ADAPTER.encode(t), output)
    }
}
