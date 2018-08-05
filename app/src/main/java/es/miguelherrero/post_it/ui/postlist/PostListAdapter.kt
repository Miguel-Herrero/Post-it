package es.miguelherrero.post_it.ui.postlist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostListAdapter(): RecyclerView.Adapter<PostListAdapter.PostListAdapterViewHolder>() {

    class PostListAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.tv_title
    }
}