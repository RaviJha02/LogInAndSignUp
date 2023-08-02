package com.example.loginandsignup

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginandsignup.databinding.ActivityForgotPasswordBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.ForgetPass.setOnClickListener {
            val email = binding.ForgetEmailEt.text.toString()

            if (email.isNotEmpty()) {
//                forgotPassword()
                firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(OnCompleteListener<Void?> { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText(this, "Error: "+task.exception!!.message, Toast.LENGTH_SHORT).show()
                        }
                    })
            }
//            }else {
//                Toast.makeText(this, "Empty Fields Are Not Allowed !!", Toast.LENGTH_SHORT).show()
//            }
        }
    }


//    private fun forgotPassword() {
//
//        firebaseAuth.sendPasswordResetEmail(email)
//            .addOnCompleteListener(OnCompleteListener<Void?> { task ->
//                if (task.isSuccessful) {
//                    Log.d(TAG, "Email sent.")
//                }
//            })
//    }
}
