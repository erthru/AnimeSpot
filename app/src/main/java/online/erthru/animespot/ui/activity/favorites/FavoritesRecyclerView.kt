package online.erthru.animespot.ui.activity.favorites

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_favorites.view.*
import online.erthru.animespot.R
import online.erthru.animespot.local.model.Favorite
import online.erthru.animespot.ui.activity.anime.AnimeActivity

class FavoritesRecyclerView(val context: FavoritesActivity, val arrayList: ArrayList<Favorite>?) : RecyclerView.Adapter<FavoritesRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_favorites,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val favorites = arrayList?.get(position)
        holder.v.tvTitleFavorites.text = favorites?.favorites_anime_name
        Glide.with(context).load(favorites?.favorites_anime_image).into(holder.v.imgFavorites)
        holder.v.setOnClickListener {
            val i = Intent(context,AnimeActivity::class.java)
            i.putExtra("id",favorites?.favorites_anime_id.toString())
            context.startActivity(i)
        }

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)

}