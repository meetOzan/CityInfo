package com.meetozan.cityinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var rv: RecyclerView
    val db = Firebase.firestore.collection("cities")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLiveCity()
    }

    private fun getLiveCity() {
        db.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            firebaseFirestoreException?.let {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            querySnapshot?.let {
                val cityList: ArrayList<City> = ArrayList()
                for (document in it) {
                    val city = document.toObject<City>()
                    cityList.add(city)
                }
                rv = findViewById(R.id.mainRv)
                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.setHasFixedSize(true)

                adapter = MainAdapter(cityList,this@MainActivity)
                rv.adapter = adapter
            }
        }
    }
}
