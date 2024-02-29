package com.slivtis.tienda.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val DATABASE_NAME = "store_database"
}