package online.erthru.animespot.ui.activity.favorites

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_favorites.*
import online.erthru.animespot.R
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.local.SQLiteHelper

class FavoritesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorGreenDark)
        }

        rvFavorites.layoutManager = GridLayoutManager(this,2)
        rvFavorites.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        rvFavorites.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        imgBackFavorites.setOnClickListener { this.finish() }

    }

    override fun onResume() {
        super.onResume()
        val adapter = FavoritesRecyclerView(this,SQLiteHelper(this).allFavorites())
        adapter.notifyDataSetChanged()
        rvFavorites.adapter = adapter
    }

}
