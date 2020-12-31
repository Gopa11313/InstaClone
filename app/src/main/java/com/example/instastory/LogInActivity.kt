package com.example.instastory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.instastory.model.Profile

class LogInActivity : AppCompatActivity() {
    private lateinit var email:EditText;
    private lateinit var password:EditText;
    private lateinit var btn:Button;
    private lateinit var signup:TextView;
    var p_email:String="";
    var p_password:String="";
    var name:String="";
    var cid=""
    var img:String=""
    val list= arrayListOf<Profile>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btn = findViewById(R.id.btn)
        signup = findViewById(R.id.signup)
        btn.setOnClickListener(){
            if (email.text.toString() == p_email && password.text.toString() == p_password) {
                val intent=Intent(this, MainActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("img",img)
                intent.putExtra("cid",cid)
                startActivity(intent)
                Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter valid email and password", Toast.LENGTH_LONG)
                    .show()
            }
        }
        signup.setOnClickListener() {
            val req=1
            startActivityForResult(Intent(this,SignupActivity::class.java),req)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode==Activity.RESULT_OK) {
                var profile= data?.getParcelableExtra<Profile>("listprofile")
                list.add(profile!!)
                p_email=list.get(0).email.toString()
                p_password=list.get(0).password.toString()
                val fname=list.get(0).fname.toString()
                val lname=list.get(0).lname.toString()
                name="$fname $lname"
                img=list.get(0).img.toString()
                cid=list.get(0).cid.toString()
            }
        }
    }


}