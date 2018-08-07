package es.miguelherrero.post_it.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application): Int {
        return 2
    }
}