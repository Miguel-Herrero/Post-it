package es.miguelherrero.post_it.ui.postlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.miguelherrero.post_it.R
import es.miguelherrero.post_it.domain.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostListAdapter(): RecyclerView.Adapter<PostListAdapter.PostListAdapterViewHolder>() {

    lateinit var data: List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapterViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostListAdapterViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return data.let { it.size }
    }

    override fun onBindViewHolder(holder: PostListAdapterViewHolder, position: Int) {
        data.let { posts ->
            holder.title.text = posts[position].title
        }
    }

    class PostListAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.tv_title
    }
}