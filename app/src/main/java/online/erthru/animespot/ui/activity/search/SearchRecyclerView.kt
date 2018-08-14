package online.erthru.animespot.ui.activity.search

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_search.view.*
import online.erthru.animespot.R
import online.erthru.animespot.network.model.Result
import online.erthru.animespot.ui.activity.anime.AnimeActivity

class SearchRecyclerView(val context:SearchActivity, val arrayList: ArrayList<Result>?) : RecyclerView.Adapter<SearchRecyclerView.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_search,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val result = arrayList?.get(position)
        holder.v.tvTitleLS1.text = result?.title
        holder.v.tvDescrLS1.text = "Description: "+result?.description
        holder.v.tvScoreLS1.text = "Score: "+result?.score
        Glide.with(context).load(result?.image_url).into(holder.v.imgLS1)
        holder.v.setOnClickListener {
            val i = Intent(context,AnimeActivity::class.java)
            i.putExtra("id",result?.mal_id?.toString())
            context.startActivity(i)
        }

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)

}