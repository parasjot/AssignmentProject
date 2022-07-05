package com.example.naviassignmentproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naviassignmentproject.R
import com.example.naviassignmentproject.model.ClosedPrModel
import com.example.naviassignmentproject.model.ClosedPrModelItem
import com.example.naviassignmentproject.viewmodel.ClosedPrViewModel
import kotlinx.android.synthetic.main.fragment_closedpr.*


class ClosedPrFragment : Fragment() {
    private lateinit var closedPrViewModel: ClosedPrViewModel

    private fun getClosedPrViewModel(): ClosedPrViewModel {
        return ViewModelProvider(requireActivity())[ClosedPrViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_closedpr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closedPrViewModel = getClosedPrViewModel()
        observerClosedPrList()
        closedPrViewModel.getClosedPrList()
    }

    private fun setRecyclerView(list: List<ClosedPrModelItem>) {
        rv_closed_pr.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_closed_pr.adapter = ClosedPrRecyclerViewAdapter(list)
    }

    private fun observerClosedPrList() {
        closedPrViewModel.closedPrList.observe(viewLifecycleOwner, Observer {
            if (it != null && it.isNotEmpty())
                setRecyclerView(it)
            else {
                //show view with no data available
                Toast.makeText(context, "No data", Toast.LENGTH_LONG).show()
            }
        })
    }
}