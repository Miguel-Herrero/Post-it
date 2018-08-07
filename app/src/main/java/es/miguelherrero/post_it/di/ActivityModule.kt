package es.miguelherrero.post_it.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.miguelherrero.post_it.PostListActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindPostListActivity(): PostListActivity
}