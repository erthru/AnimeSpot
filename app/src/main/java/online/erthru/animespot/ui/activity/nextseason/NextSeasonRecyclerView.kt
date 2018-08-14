package online.erthru.animespot.ui.activity.nextseason

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_next_season.view.*
import kotlinx.android.synthetic.main.list_season.view.*
import online.erthru.animespot.R
import online.erthru.animespot.network.model.Season
import online.erthru.animespot.ui.activity.anime.AnimeActivity

class NextSeasonRecyclerView(val context: NextSeasonActivity, val arrayList: ArrayList<Season>?) : RecyclerView.Adapter<NextSeasonRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_next_season, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val season = arrayList?.get(position)

        holder.v.tvTitleLNS.text = season?.title
        holder.v.tvSynopsisLNS.text = "Synopsis: "+season?.synopsis

        if(season?.producer?.size == 0) {
            holder.v.tvProducerLNS.text = "Producer: null"
        }else{
            holder.v.tvProducerLNS.text = "Producer: "+season?.producer?.get(0)?.name
        }

        holder.v.tvSourceLNS.text = "Source: "+season?.source
        holder.v.tvAiringLNS.text = "Airing: "+season?.airing_start
        Glide.with(context).load(season?.image_url).into(holder.v.imgLNS)
        holder.v.setOnClickListener {
            val i = Intent(context, AnimeActivity::class.java)
            i.putExtra("id",season?.mal_id.toString())
            context.startActivity(i)
        }

    }

    class Holder(val v: View) : RecyclerView.ViewHolder(v)

}