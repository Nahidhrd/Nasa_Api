package com.example.nasa_api_astoried_radar.utils

import com.example.nasa_api_astoried_radar.data.remote.api.Asteroid
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun parseAsteroidJsonResult(jsonObject: JSONObject) :ArrayList<Asteroid>{

    val nearEarthObjects = jsonObject.getJSONObject("near_earth_objects")
    val asteroidList = ArrayList<Asteroid>()
    val next7days = getNext7Days()


    for (formatedate in  next7days){

        if (nearEarthObjects.has(formatedate)) {

            val dateWiseData = nearEarthObjects.getJSONArray(formatedate)

            for (index in 0 until dateWiseData.length()) {

                val asteroidJson = dateWiseData.getJSONObject(index)

                val id = asteroidJson.getLong("id")
                val codename = asteroidJson.getString("name")

                val closeApproachData = asteroidJson
                    .getJSONArray("close_approach_data")
                    .getJSONObject(0)

                val closeApproachDate = closeApproachData.getString("close_approach_date")

                val isPotentiallyHazardous = asteroidJson.getBoolean("is_potentially_hazardous_asteroid")

                val asteroid = Asteroid(
                    id= id,
                    codename = codename,
                    closeApproachDate = closeApproachDate,
                    absoluteMagnitude = 0.0,
                    estimatedDiameter = 0.0,
                    relativeVelocity = 0.0,
                    distanceFromEarth = 0.0,
                    isPotentiallyHazardous = isPotentiallyHazardous

                    )

                asteroidList.add(asteroid)

            }
            
        }

    }

    return asteroidList
}




fun getNext7Days(): ArrayList<String> {
    val listOfDays = ArrayList<String>()
    val calendar = Calendar.getInstance()

    for (i in 1..7) {
        val currentTime = calendar.time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        listOfDays.add(dateFormat.format(currentTime))
        calendar.add(Calendar.DAY_OF_YEAR, 1)
    }

    return listOfDays
}