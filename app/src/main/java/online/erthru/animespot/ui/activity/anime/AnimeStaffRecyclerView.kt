package online.erthru.animespot.ui.activity.anime

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_staff_anime.view.*
import online.erthru.animespot.R
import online.erthru.animespot.network.model.Staff

class AnimeStaffRecyclerView(val context: AnimeActivity, val arrayList: ArrayList<Staff>?) : RecyclerView.Adapter<AnimeStaffRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_staff_anime, parent, false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val staff = arrayList?.get(position)

        holder.v.tvNameStaffLSA.text = staff?.name
        holder.v.tvRoleStaffLSA.text = staff?.role
        Glide.with(context).load(staff?.image_url).into(holder.v.imgStaffLSA)

    }

    class Holder(val v:View) : RecyclerView.ViewHolder(v)
}