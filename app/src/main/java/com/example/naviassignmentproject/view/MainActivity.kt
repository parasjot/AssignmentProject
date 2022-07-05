package com.example.naviassignmentproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.naviassignmentproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()


        //add a fragment, to make future enhancements easier
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view_tag, ClosedPrFragment())
        transaction.commit()
    }
}