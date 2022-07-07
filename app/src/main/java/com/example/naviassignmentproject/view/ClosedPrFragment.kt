package com.example.naviassignmentproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naviassignmentproject.R
import com.example.naviassignmentproject.model.ClosedPrModelItem
import com.example.naviassignmentproject.utils.CommonUtils
import com.example.naviassignmentproject.viewmodel.ClosedPrViewModel
import kotlinx.android.synthetic.main.fragment_closedpr.*


class ClosedPrFragment : Fragment() {
    private lateinit var closedPrViewModel: ClosedPrViewModel
    private lateinit var closedPrRecyclerViewAdapter: ClosedPrRecyclerViewAdapter

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
        if (context != null && CommonUtils.isOnline(context!!)) {
            closedPrViewModel.getClosedPrList()
        } else {
            //try again ui
            showTryAgainUi()
        }
    }

    private fun showTryAgainUi() {
        try_again.visibility = View.VISIBLE
        rv_closed_pr.visibility = View.GONE
        progressbar.visibility = View.GONE

        try_again.setOnClickListener {
            try_again.visibility = View.GONE
            progressbar.visibility = View.VISIBLE
            closedPrViewModel.getClosedPrList()
        }
    }

    private fun setRecyclerView(list: List<ClosedPrModelItem>) {
        if (!::closedPrRecyclerViewAdapter.isInitialized) {
            rv_closed_pr.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            closedPrRecyclerViewAdapter = ClosedPrRecyclerViewAdapter(list)
            rv_closed_pr.adapter = closedPrRecyclerViewAdapter
            closedPrRecyclerViewAdapter.notifyDataSetChanged()
            rv_closed_pr.scheduleLayoutAnimation()
        } else {
            closedPrRecyclerViewAdapter.setClosePrList(list)
            closedPrRecyclerViewAdapter.notifyDataSetChanged()
            rv_closed_pr.scheduleLayoutAnimation()
        }
    }

    private fun observerClosedPrList() {
        closedPrViewModel.closedPrList.observe(viewLifecycleOwner, Observer {
            if (it != null && it.isNotEmpty()) {
                try_again.visibility = View.GONE
                progressbar.visibility = View.GONE
                rv_closed_pr.visibility = View.VISIBLE
                setRecyclerView(it)
            } else {
                showTryAgainUi()
            }
        })
    }
}