package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class JoinActiviy : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_activiy)


        auth=Firebase.auth
        val email=findViewById<TextView>(R.id.emailArea)
        val password=findViewById<TextView>(R.id.passwordArea)

        val joinbtn=findViewById<Button>(R.id.joinBTN)
        joinbtn.setOnClickListener{

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    } else {

                    }
                }

        }
        val loginBTN=findViewById<Button>(R.id.loginBTN)
        loginBTN.setOnClickListener{
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent= Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this,"비밀번호 혹은 이메일이 올바르지않습니다.",Toast.LENGTH_SHORT).show()

                    }
                }

        }

    }
}