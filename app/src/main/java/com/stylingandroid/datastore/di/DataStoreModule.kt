package com.stylingandroid.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import androidx.datastore.dataStoreFile
import com.stylingandroid.datastore.data.ComplexData
import com.stylingandroid.datastore.data.ComplexDataSerializer
import com.stylingandroid.datastore.security.Crypto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    fun providesSerializer(crypto: Crypto): Serializer<ComplexData> =
        ComplexDataSerializer(crypto)

    @Provides
    fun providesComplexDataStore(
        @ApplicationContext context: Context,
        serializer: Serializer<ComplexData>
    ): DataStore<ComplexData> = DataStoreFactory.create(
        produceFile = { context.dataStoreFile("ComplexDataDataStore.pb") },
        serializer = serializer
    )
}
