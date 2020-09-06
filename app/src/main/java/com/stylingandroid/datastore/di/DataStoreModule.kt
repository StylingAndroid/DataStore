package com.stylingandroid.datastore.di

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import com.stylingandroid.datastore.data.SimpleData
import com.stylingandroid.datastore.data.SimpleDataSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object DataStoreModule {

    @Provides
    fun providesDataStore(@ApplicationContext context: Context): DataStore<SimpleData> =
        context.createDataStore(
            fileName = "DataStoreTest.pb",
            serializer = SimpleDataSerializer
        )
}
