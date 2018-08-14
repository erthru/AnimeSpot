package online.erthru.animespot

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class Utility {

    companion object {

        fun getSeason() : String?{

            val c = Calendar.getInstance().time
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            sdf.timeZone = TimeZone.getTimeZone("Japan")
            val date = sdf.format(c)

            val date1 = date.substring(5,7).toInt()
            Log.d("SEASON", date1.toString())

            return if(date1 >= 3 && date1 < 6){
                "Spring"
            }else if(date1 >= 6 && date1 < 9){
                "Summer"
            }else if(date1 >= 9 && date1 < 12){
                "Fall"
            }else if(date1 >= 12 && date1 < 3){
                "Winter"
            }else{
               null
            }

        }

        fun getNextSeason() : String?{

            return if(getSeason().equals("Winter")){
                "Spring"
            }else if(getSeason().equals("Spring")){
                "Summer"
            }else if(getSeason().equals("Summer")){
                "Fall"
            }else if(getSeason().equals("Fall")){
                "Winter"
            }else{
                null
            }

        }

        fun getYear() : Int{

            val c = Calendar.getInstance().time
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            sdf.timeZone = TimeZone.getTimeZone("Japan")
            val year = sdf.format(c).substring(0,4)

            return year.toInt()

        }

        fun getToDay() : String?{

            val c = Calendar.getInstance().time
            val sdf = SimpleDateFormat("EEEE")
            sdf.timeZone = TimeZone.getTimeZone("Japan")
            val day = sdf.format(c)

            return day

        }

        fun getTomorrow() : String?{

            val c = Calendar.getInstance()
            c.add(Calendar.DAY_OF_YEAR,1)
            val sdf = SimpleDateFormat("EEEE")
            sdf.timeZone = TimeZone.getTimeZone("Japan")
            val day = sdf.format(c.time)

            return day

        }

        fun getCurrentJST() : String?{

            val c = Calendar.getInstance().time
            val sdf = SimpleDateFormat("EEEE HH:mm")
            sdf.timeZone = TimeZone.getTimeZone("Japan")
            val day = sdf.format(c)

            return day


        }

    }

}