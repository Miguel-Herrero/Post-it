package es.miguelherrero.post_it.data.remote

import es.miguelherrero.post_it.domain.model.Post
import es.miguelherrero.post_it.utils.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostsApi {
    @GET("posts/")
    fun getPosts(): Call<List<Post>>

    companion object {
        fun create(): PostsApi {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create((PostsApi::class.java))
        }
    }
}