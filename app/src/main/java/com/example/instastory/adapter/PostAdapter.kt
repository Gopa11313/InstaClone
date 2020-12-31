package com.example.instastory.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instastory.DetailActivity
import com.example.instastory.R
import com.example.instastory.model.post
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter(
    val lstPost: ArrayList<post>,
    val context: Context):RecyclerView.Adapter<PostAdapter.PostViewholder>(){
        class PostViewholder(view: View) : RecyclerView.ViewHolder(view) {
            val post_img: ImageView;
            val img1:CircleImageView
            val name:TextView;
            val like:TextView;
            val discription:TextView
            init {
                post_img = view.findViewById(R.id.img2)
                name=view.findViewById(R.id.name)
                img1=view.findViewById(R.id.img1)
                like=view.findViewById(R.id.like)
                discription=view.findViewById(R.id.discription)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewholder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.post,parent,false)
        return PostViewholder(view)
    }

    override fun onBindViewHolder(holder: PostViewholder, position: Int) {
        val post=lstPost[position];
        holder.like.text=post.likes
        holder.discription.text=post.discriptio
        holder.name.text=post.name
        Glide.with(context)
            .load(post.img2)
            .into(holder.post_img)
        Glide.with(context)
            .load(post.img1)
            .into(holder.img1)


//        holder.story_profile.setOnClickListener(){
//            val intent= Intent(context, DetailActivity::class.java)
//            intent.putExtra("story",post)
//            context.startActivity(intent);
//        }
    }

    override fun getItemCount(): Int {
        return lstPost.size
    }
}