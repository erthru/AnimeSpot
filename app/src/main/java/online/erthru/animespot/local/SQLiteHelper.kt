package online.erthru.animespot.local

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import online.erthru.animespot.local.model.Favorite

class SQLiteHelper(val context: Context) : SQLiteOpenHelper(context,"db_anime_spot",null,1) {

    companion object {
        const val TABLE_FAVORITES = "tb_favorites"
        const val FAVORITES_ANIME_ID = "favorites_anime_id"
        const val FAVORITES_ANIME_NAME = "favorites_anime_name"
        const val FAVORITES_ANIME_IMG = "favorites_anime_image"
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        val CREATE_FAVORITES_TABLE = "CREATE TABLE $TABLE_FAVORITES (" +
                "$FAVORITES_ANIME_ID INT(20)," +
                "$FAVORITES_ANIME_NAME TEXT," +
                "$FAVORITES_ANIME_IMG TEXT" +
                ")"

        p0?.execSQL(CREATE_FAVORITES_TABLE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun isFavorites(animeId:Int?) : Boolean{

        var getAnimeId:Int? = null

        val db = writableDatabase
        val cursor = db.rawQuery("SELECT $FAVORITES_ANIME_ID FROM $TABLE_FAVORITES WHERE $FAVORITES_ANIME_ID=$animeId",null)

        if(cursor.moveToFirst()){
            getAnimeId = cursor.getInt(0)
        }

        return if(animeId == getAnimeId){
            true
        }else{
            false
        }

    }

    fun addToFavorites(animeId:Int?,animeName:String?,animeImg:String?){

        val db = writableDatabase
        db.execSQL("INSERT INTO $TABLE_FAVORITES ($FAVORITES_ANIME_ID,$FAVORITES_ANIME_NAME,$FAVORITES_ANIME_IMG) VALUES($animeId,'$animeName','$animeImg')")

    }

    fun removeFromFavorites(animeId:Int?){

        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_FAVORITES WHERE $FAVORITES_ANIME_ID=$animeId")

    }

    fun allFavorites() : ArrayList<Favorite>{

        var arrayList = ArrayList<Favorite>()
        val db = writableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_FAVORITES ORDER BY $FAVORITES_ANIME_ID DESC",null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){

                arrayList.add(Favorite(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)))

                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun countFavorites() : Int{

        var total = 0

        val db = writableDatabase
        val cursor = db.rawQuery("SELECT COUNT($FAVORITES_ANIME_ID) FROM $TABLE_FAVORITES",null)
        if(cursor.moveToFirst()){

            total = cursor.getInt(0)

        }

        return total

    }

}