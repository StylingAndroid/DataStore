package com.stylingandroid.datastore.data

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object SimpleDataSerializer : Serializer<SimpleData> {

    override fun readFrom(input: InputStream): SimpleData {
        return try {
            SimpleData.ADAPTER.decode(input)
        } catch (exception: IOException) {
            throw CorruptionException("Cannot read proto", exception)
        }
    }

    override fun writeTo(t: SimpleData, output: OutputStream) {
        SimpleData.ADAPTER.encode(output, t)
    }
}
