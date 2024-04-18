package com.example.grouppprogect_unit9

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class DogProfile : AppCompatActivity() {
    private val apiUrl = "https://api.adoptapet.me/ap/10015514"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dog_profile)
        val client = AsyncHttpClient()
        client.get(apiUrl, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                Log.d("API", "Request successful! Response: $response")
                val name = findViewById<TextView>(R.id.dogName)
                val description = findViewById<TextView>(R.id.dogDescription)
                val color = findViewById<TextView>(R.id.dogColor)
                val age = findViewById<TextView>(R.id.dogAge)
                val sex = findViewById<TextView>(R.id.dogGender)
                val imageView = findViewById<ImageView>(R.id.dogImage)

                val dogName = response.optString("name")
                val dogColor = response.optString("color")
                val dogDesc = response.optString("desc")
                val dogAge = response.optString("age")
                val dogSex = response.optString("sex")
                val dogImageUrl = response.optString("imageUrl")
                name.text = dogName
                description.text = dogDesc
                color.text = dogColor
                age.text = dogAge
                sex.text = dogSex
                Glide.with(this@DogProfile)
                    .load(dogImageUrl)
                    .into(imageView)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>?,
                throwable: Throwable,
                errorResponse: JSONObject?
            )
            {
               Log.e("API", "Request failed with status code $statusCode")
                if (errorResponse != null) {
                    Log.e("API", "Error response: $errorResponse")
                }
            }

        }
            )
        }
    }