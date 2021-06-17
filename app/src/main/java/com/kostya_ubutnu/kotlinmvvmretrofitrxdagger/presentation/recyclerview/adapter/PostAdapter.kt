package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.R
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import okhttp3.Response

class PostAdapter: ListAdapter<Post,PostAdapter.PostViewHolder>(myDiffUtilCallback) {

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val postTitle = view.findViewById<TextView>(R.id.post_title)

        fun bind(post: Post) {
            postTitle.text = post.postTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = getItem(position)
        holder.bind(currentPost)
    }


}

val myDiffUtilCallback = object : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.postId == newItem.postId
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.postTitle == newItem.postTitle
    }

}