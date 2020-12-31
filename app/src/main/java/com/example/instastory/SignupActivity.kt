package com.example.instastory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.instastory.model.Profile

class SignupActivity : AppCompatActivity() {
    val batch= arrayOf("19-c","19-d","20-a","20-b","20-c")
    private lateinit var cid:EditText;
    private lateinit var fname:EditText;
    private lateinit var lname:EditText;
    private lateinit var email:EditText;
    private lateinit var password:EditText;
    private lateinit var batch_need:Spinner;
    private lateinit var img:EditText;
    private lateinit var btn:Button;
    var selectedItem=""
    private val listProfile=ArrayList<Profile>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        cid=findViewById(R.id.cid)
        fname=findViewById(R.id.fname)
        lname=findViewById(R.id.lname)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        batch_need=findViewById(R.id.spinner)
        img=findViewById(R.id.img)
        btn=findViewById(R.id.btn)
        val adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            batch
        )
        batch_need.adapter = adapter1
        batch_need.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = parent?.getItemAtPosition(position).toString();

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        btn.setOnClickListener(){
           // loaddata((cid.text.toString()).toInt(),fname.text.toString(),lname.text.toString(),email.text.toString(),password.text.toString(),selectedItem,img.text.toString())
            val id=cid.text.toString()
            val profile=Profile(id.toInt(),fname.text.toString(),lname.text.toString(),email.text.toString(),password.text.toString(),selectedItem,img.text.toString())

            val intent=Intent()
            intent.putExtra("listprofile",profile)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
//    fun loaddata(cid:Int,fname:String,lname:String,email:String,password:String,batch:String,img:String){
//        listProfile.add(Profile(cid,fname,lname,email,password,batch,img))
//    }

}