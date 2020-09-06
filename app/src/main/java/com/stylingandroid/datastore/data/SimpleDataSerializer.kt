package com.stylingandroid.datastore.data

import androidx.datastore.CorruptionException
import androidx.datastore.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object SimpleDataSerializer : Serializer<SimpleData> {

    override fun readFrom(input: InputStream): SimpleData {
        return try {
            SimpleData.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", exception)
        }
    }

    override fun writeTo(t: SimpleData, output: OutputStream) {
        t.writeTo(output)
    }
}
