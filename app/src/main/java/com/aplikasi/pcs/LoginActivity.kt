package com.aplikasi.pcs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.telecom.Call
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aplikasi.pcs.api.BaseRetrofit
import com.aplikasi.pcs.response.login.LoginRespose
import com.aplikasi.pcs.utils.SessionManager
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    companion object{
        lateinit var sessionManager: SessionManager
        private  lateinit var  context: Context
    }

    private  val api by lazy { BaseRetrofit().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)

        val loginStatus = sessionManager.getBoolean("LOGIN_STATUS")
        if (loginStatus){
            val moveIntent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }

        val btnLogin = findViewById(R.id.btnLogin) as Button
        val txtEmail = findViewById(R.id.txtEmail) as TextInputEditText
        val txtPassword = findViewById(R.id.txtPassword) as TextInputEditText

        btnLogin.setOnClickListener {
            api.login(txtEmail.text.toString(),txtPassword.text.toString()).enqueue(object : Callback<LoginRespose>{
                override fun onResponse(
                    call: Call<LoginRespose>,
                    respose: Response<LoginRespose>
                ) {
                    Log.e("Login")
                }
            })
        }
    }

}