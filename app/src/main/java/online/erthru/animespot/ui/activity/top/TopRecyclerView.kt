package online.erthru.animespot.ui.activity.top

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_top.view.*
import online.erthru.animespot.R
import online.erthru.animespot.network.model.Top
import online.erthru.animespot.ui.activity.anime.AnimeActivity

class TopRecyclerView(val context:TopActivity,val arrayList: ArrayList<Top>?) : RecyclerView.Adapter<TopRecyclerView.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_top,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val top = arrayList?.get(position)
        holder.v.tvTitleLT.text = "# "+(position+1).toString()+" "+top?.title
        holder.v.tvTypeLT.text = "Type: "+top?.type
        holder.v.tvMembersLT.text = "Members: "+top?.members
        holder.v.tvScoreLT.text = "Score: "+top?.score
        Glide.with(context).load(top?.image_url).into(holder.v.imgLT)

        holder.v.setOnClickListener {
            val i = Intent(context,AnimeActivity::class.java)
            i.putExtra("id",top?.mal_id?.toString())
            context.startActivity(i)
        }

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)
}