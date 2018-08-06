package es.miguelherrero.post_it.ui.postlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.miguelherrero.post_it.R
import es.miguelherrero.post_it.data.repository.PostRepository

class PostListFragment : Fragment() {

    private lateinit var mPostList: RecyclerView
    private lateinit var mPostListAdapter: PostListAdapter

    companion object {
        fun newInstance() = PostListFragment()
    }

    private lateinit var viewModel: PostListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_post_list, container, false)

        // 1 - Find the RecyclerView for posts list
        mPostList = view.findViewById(R.id.rv_post_list)

        // 2 - Init the adapter
        mPostListAdapter = PostListAdapter()

        // 3 - Configure de RecyclerView with the adapter
        val context = activity
        mPostList.layoutManager = LinearLayoutManager(context)
        mPostList = view.findViewById(R.id.rv_post_list)
        mPostList.adapter = mPostListAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)

        // 1 - Initialize Repository instance
        viewModel.postRepository = PostRepository()

        // 2 - Whenever Repository fetches new posts, update the adapter with new posts (setupPosts)
        viewModel.getPosts().observe(this, Observer { posts ->
            posts.let {
                mPostListAdapter.setupPosts(posts)
            }
        })
    }

}
