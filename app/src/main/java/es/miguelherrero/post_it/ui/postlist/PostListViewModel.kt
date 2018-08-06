package es.miguelherrero.post_it.ui.postlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import es.miguelherrero.post_it.data.repository.PostRepository
import es.miguelherrero.post_it.domain.model.Post
import javax.inject.Inject

class PostListViewModel: ViewModel() {
    @Inject lateinit var postRepository: PostRepository
    fun getPosts(): LiveData<List<Post>> = postRepository.getPosts()
}
