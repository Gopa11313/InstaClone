package com.example.recyclarview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instastory.DetailActivity
import com.example.instastory.R
import com.example.instastory.adapter.story
import de.hdodenhof.circleimageview.CircleImageView

class Storyadapter(
    val lststory:ArrayList<story>,
    val context:Context):RecyclerView.Adapter<Storyadapter.StoryViewholder>() {
    class StoryViewholder(view:View):RecyclerView.ViewHolder(view){
        val story_profile:CircleImageView;
        val story_name:TextView;
        init {
            story_profile=view.findViewById(R.id.img)
            story_name=view.findViewById(R.id.name);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewholder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.story,parent,false)
        return StoryViewholder(view)
    }

    override fun getItemCount(): Int {
        return lststory.size
    }

    override fun onBindViewHolder(holder: StoryViewholder, position: Int) {
        val story=lststory[position];
        holder.story_name.text=story.name;
        Glide.with(context)
            .load(story.image)
            .into(holder.story_profile)
        holder.story_profile.setOnClickListener(){
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra("story",story)
            context.startActivity(intent);
        }
    }
}