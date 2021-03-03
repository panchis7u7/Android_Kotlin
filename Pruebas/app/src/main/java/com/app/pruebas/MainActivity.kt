package com.app.pruebas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view: TextView = findViewById(R.id.textView)
        val queue: RequestQueue = Volley.newRequestQueue(this@MainActivity)
        val url: String = "http://192.168.1.133:3490/alumnos"

        val jsonRequest = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener { response ->
            view.text = "Response : %s".format(response.toString()) }, Response.ErrorListener { error -> view.text = error.message })
        queue.add(jsonRequest)
    }
}