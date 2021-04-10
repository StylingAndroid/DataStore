package com.stylingandroid.datastore.security

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.security.KeyStore
import javax.inject.Named

@Module(includes = [SecurityModule.Declarations::class])
@InstallIn(SingletonComponent::class)
object SecurityModule {

    const val KEY_NAME = "Key Name"
    const val KEY_STORE_NAME = "Key Store Name"

    private const val ANDROID_KEY_STORE_TYPE = "AndroidKeyStore"
    private const val SIMPLE_DATA_KEY_NAME = "SimpleDataKey"

    @Provides
    fun provideKeyStore(): KeyStore =
        KeyStore.getInstance(ANDROID_KEY_STORE_TYPE).apply { load(null) }

    @Provides
    @Named(KEY_NAME)
    fun providesKeyName(): String = SIMPLE_DATA_KEY_NAME

    @Provides
    @Named(KEY_STORE_NAME)
    fun providesKeyStoreName(): String = ANDROID_KEY_STORE_TYPE

    @Module
    @InstallIn(SingletonComponent::class)
    interface Declarations {

        @Binds
        fun bindsCipherProvider(impl: AesCipherProvider): CipherProvider

        @Binds
        fun bindsCrypto(impl: CryptoImpl): Crypto
    }
}
