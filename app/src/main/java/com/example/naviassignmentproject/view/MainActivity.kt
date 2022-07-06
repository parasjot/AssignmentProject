package com.example.naviassignmentproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.naviassignmentproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //add a fragment, to make future enhancements easier
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view_tag, ClosedPrFragment())
        transaction.commit()
    }
}