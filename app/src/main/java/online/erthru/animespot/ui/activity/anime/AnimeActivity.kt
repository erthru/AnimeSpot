package online.erthru.animespot.ui.activity.anime

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_anime.*
import kotlinx.android.synthetic.main.list_season.view.*
import online.erthru.animespot.R
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.local.SQLiteHelper
import online.erthru.animespot.network.model.Genre
import online.erthru.animespot.network.model.Staff

class AnimeActivity : BaseActivity(), AnimeContract.View {

    lateinit var presenter: AnimeContract.Presenter
    lateinit var i:Intent
    lateinit var animeImage:String

    companion object {
        var KEY_IS_FAVORITE = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorGray)
        }

        i = intent

        initProgressBar(pbAnime)

        presenter = AnimePresenter(this)

        rvStaffAnime.layoutManager = LinearLayoutManager(this)
        rvStaffAnime.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        rvStaffAnime.isNestedScrollingEnabled = false

        imgCloseAnime.setOnClickListener { this.finish() }

        if(SQLiteHelper(this).isFavorites(i.getStringExtra("id").toInt())){
            imgFavoriteAnime.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_gray_24dp))
            KEY_IS_FAVORITE = true
        }else{
            imgFavoriteAnime.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_gray_24dp))
            KEY_IS_FAVORITE = false
        }

        imgFavoriteAnime.setOnClickListener {
            if(KEY_IS_FAVORITE){
                imgFavoriteAnime.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_gray_24dp))
                SQLiteHelper(this).removeFromFavorites(i.getStringExtra("id").toInt())
                showSuccessMessage("Removed from favorites")
                KEY_IS_FAVORITE = false
            }else{
                imgFavoriteAnime.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_gray_24dp))
                SQLiteHelper(this).addToFavorites(i.getStringExtra("id").toInt(),tvTitleAnime.text.toString(),animeImage)
                showSuccessMessage("Added to favorites")
                KEY_IS_FAVORITE = true
            }
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.loadDetail(i.getStringExtra("id").toInt())
        presenter.loadStaff(i.getStringExtra("id").toInt())
    }

    override fun detailLoaded(data: HashMap<String, Any>?, genre: ArrayList<Genre>?) {

        tvTitleAnime.text = data?.get("title").toString()
        tvJapanTitleAnime.text = "Japanese Title: "+data?.get("title_japanese").toString()
        Glide.with(this).load(data?.get("image_url")).into(imgAnime)
        tvTypeAnime.text = "Type: "+data?.get("type").toString()
        tvSourceAnime.text = "Source: "+data?.get("source").toString()
        tvStatusAnime.text = "Status: "+data?.get("status").toString()
        tvAiredStartingAnime.text = "Aired: "+data?.get("aired_string").toString()
        tvDurationAnime.text = "Duration: "+data?.get("duration").toString()
        tvRatingAnime.text = "Rating: "+data?.get("rating").toString()
        tvScoreAnime.text = "Score: "+data?.get("score").toString()
        tvScoreByAnime.text = "Scored By: "+data?.get("scored_by").toString()
        tvRankAnime.text = "Rank: "+data?.get("rank").toString()
        tvPopularityAnime.text = "Popularity: "+data?.get("popularity").toString()
        tvMembersAnime.text = "Members: "+data?.get("members").toString()
        tvFavoritesAnime.text = "Favorites: "+data?.get("favorites").toString()
        tvSynopsisAnime.text = "Synopsis: "+data?.get("synopsis").toString()
        tvBroadcastAnime.text = "Broadcast: "+data?.get("broadcast").toString()
        tvProducerAnime.text = "Producer: "+data?.get("producer").toString()
        layouDetailAnime.visibility = View.VISIBLE

        imgFavoriteAnime.visibility = View.VISIBLE
        animeImage = data?.get("image_url").toString()

        var genreList = ""
        for(i in 0 until genre?.size!!){
            genreList += genre?.get(i)?.name+", "
        }

        tvGenreAnime.text = "Genre: "+genreList

    }

    override fun staffLoaded(data: ArrayList<Staff>?) {
        val adapter = AnimeStaffRecyclerView(this, data)
        adapter.notifyDataSetChanged()
        rvStaffAnime.adapter = adapter
    }

}
