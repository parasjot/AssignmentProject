package com.example.naviassignmentproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.naviassignmentproject.R
import com.example.naviassignmentproject.model.ClosedPrModelItem
import kotlinx.android.synthetic.main.rv_closed_pr_item.view.*

class ClosedPrRecyclerViewAdapter(closedPrList: List<ClosedPrModelItem>) :
    RecyclerView.Adapter<ClosedPrViewHolder>() {
    private var closedPrList: List<ClosedPrModelItem> = closedPrList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClosedPrViewHolder {
        val inflatedView = parent.inflate(R.layout.rv_closed_pr_item, false)
        return ClosedPrViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ClosedPrViewHolder, position: Int) {
        //set rv items
        val closedPrModelItem = closedPrList.get(position)
        val photoUrl = closedPrModelItem.user.avatar_url
        val createDate = closedPrModelItem.created_at
        val closedDate = closedPrModelItem.closed_at
        val userName = closedPrModelItem.user.login
        val title = closedPrModelItem.title
        holder.itemView.createdDate.text = "Created: $createDate"
        holder.itemView.closedDate.text = "Closed: $closedDate"
        holder.itemView.title.text = title
        holder.itemView.userName.text = userName
        val url = if (photoUrl != null) "$photoUrl?w=360" else null //1
        Glide.with(holder.itemView)  //2
            .load(url) //3
            .centerCrop() //4
            .placeholder(R.drawable.ic_launcher_background) //5
            .error(R.drawable.ic_launcher_background) //6
            .fallback(R.drawable.ic_launcher_background) //7
            .into(holder.itemView.userImage) //8
    }

    override fun getItemCount(): Int {
        return closedPrList.size
    }

    open fun setClosedPrList(list: List<ClosedPrModelItem>) {
        closedPrList = list
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
