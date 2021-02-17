package com.example.folhadeponto

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.folhadeponto.loginRouter.APIService
import com.example.folhadeponto.loginRouter.LoginData
import com.example.folhadeponto.loginRouter.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Instância dos componentes
        val buttonSubmit = findViewById<Button>(R.id.ButtonLogin)
        val UsernameText = findViewById<TextView>(R.id.UsernameLogin)
        val PasswordText = findViewById<TextView>(R.id.PasswordLogin)

        // setOnClickListener dispara uma ação quando o botão é clicado
        buttonSubmit.setOnClickListener {

            // Configs do Retrofit - ApiServices
            var mAPIService: APIService? = null
            mAPIService = APIService.ApiUtils.apiService

            // Capturando texto das textareas
            val UserString = UsernameText.text.toString()
            val PassString = PasswordText.text.toString()

            // Aqui se chama a função que é setada como post, ou seja, ao chama-la estou automa-
            // ticamente realizando um post pro servidor com as configs do retrofit feitas acima
            mAPIService.postLogin(
                LoginData(UserString, PassString))
                    .enqueue(object :
                Callback<ResponseBody> {

                // Função chamada quando a request deu certo,
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                    // pego o response do post request
                    val responseString = response.body()?.StatusCode.toString()
                    println(responseString)

                    if(responseString == "200"){
                        val showHomepage = Intent(this@LoginActivity, HomepageActivity::class.java)
                        startActivity(showHomepage)
                    }
                    else{
                        Toast.makeText(this@LoginActivity, "Usuário ou senha incorretos !", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    // Caso haja erro de requisição
                }
            })
        }


    }
}