package es.miguelherrero.post_it.ui.postlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.miguelherrero.post_it.R
import es.miguelherrero.post_it.domain.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.PostListAdapterViewHolder>() {

    // 1 - Store the list data
    var data: List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapterViewHolder {
        // 2 - Inflate the item view layout and pass it to the viewHolder
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostListAdapterViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        // 3 - Return how many items are there
        return data.let { it.size }
    }

    override fun onBindViewHolder(holder: PostListAdapterViewHolder, position: Int) {
        // 4 - Fill the viewHolder text views with the data
        data.let { posts ->
            holder.title.text = posts[position].title
        }
    }

    // 5 - Create an auxiliary function to populate data from other source
    fun setupPosts(posts: List<Post>) {
        data = posts
        notifyDataSetChanged()
    }

    class PostListAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.tv_title
    }
}