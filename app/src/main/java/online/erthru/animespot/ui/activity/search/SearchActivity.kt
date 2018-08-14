package online.erthru.animespot.ui.activity.search

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_search.*
import online.erthru.animespot.R
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.network.model.Result

class SearchActivity : BaseActivity(), SearchContract.View {

    lateinit var presenter: SearchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorGray)
        }

        presenter = SearchPresenter(this)

        initProgressBar(pbSearch)
        rvSearch.layoutManager = LinearLayoutManager(this)
        rvSearch.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        imgBackSearch.setOnClickListener { this.finish() }

        edSearch.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(p0: Editable?) {

                if(p0.toString().isNullOrBlank()){
                    showProgressBar()
                }else{
                    presenter.search(p0.toString())
                }

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

    }

    override fun searchResult(data: ArrayList<Result>?) {

        val adapter = SearchRecyclerView(this,data)
        adapter.notifyDataSetChanged()
        rvSearch.adapter = adapter

    }

}
