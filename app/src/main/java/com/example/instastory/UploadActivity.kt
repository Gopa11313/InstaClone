package com.example.instastory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.instastory.model.ExtraPost
import com.example.instastory.model.Profile
import com.example.instastory.model.post

class UploadActivity : AppCompatActivity() {
    private lateinit var img1:TextView;
    private lateinit var status:TextView;
    private lateinit var post:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        img1=findViewById(R.id.img1)
        status=findViewById(R.id.status)
        post=findViewById(R.id.post)
        post.setOnClickListener(){
            val extrapost=ExtraPost(img1.text.toString(),status.text.toString())
            val intent= Intent()
            intent.putExtra("Extrapost",extrapost)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}