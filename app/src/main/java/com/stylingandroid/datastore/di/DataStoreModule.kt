package com.stylingandroid.datastore.di

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import com.stylingandroid.datastore.data.ComplexData
import com.stylingandroid.datastore.data.ComplexDataSerializer
import com.stylingandroid.datastore.security.Crypto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object DataStoreModule {

    @Provides
    fun providesComplexDataStore(
        @ApplicationContext context: Context,
        crypto: Crypto
    ): DataStore<ComplexData> =
        context.createDataStore(
            fileName = "ComplexDataStoreTest.pb",
            serializer = ComplexDataSerializer(crypto)
        )
}
