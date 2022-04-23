package com.roger.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.roger.authenticate.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProfileBinding
    private var auth: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            Glide.with(this@ProfileActivity)
                .load(auth.currentUser?.photoUrl)
                .centerCrop()
                .into(ivAvatar)

            tvUserName.text = auth.currentUser?.displayName

            clSignOut.setOnClickListener {
                auth.signOut()
                val intent = Intent(this@ProfileActivity, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
    }
}