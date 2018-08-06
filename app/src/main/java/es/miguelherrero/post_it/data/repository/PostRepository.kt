package es.miguelherrero.post_it.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import es.miguelherrero.post_it.data.remote.PostsApi
import es.miguelherrero.post_it.domain.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    private var postsApi: PostsApi = PostsApi.create()

    fun getPosts(): MutableLiveData<List<Post>> {
        // 1 - This call will return this MutableLiveData
        var data: MutableLiveData<List<Post>> = MutableLiveData()

        // 2 - Call to the Webservice function and implement Callback object abstract functions
        postsApi.getPosts().enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Log.e("PostRepository", "Error getting posts")
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                // 3 - Set the MutableLiveData value
                data.value = response?.body()
            }

        })

        // 4 - Return the data
        return data
    }
}