package com.magdy.myforecast.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.magdy.myforecast.R
import com.magdy.myforecast.data.ApiService
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = ApiService()

        /*val call = apiService.getCurrentWeahter2("London")
        call.enqueue(object : Callback<CurrentWeatherResponse> {
            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<CurrentWeatherResponse>,
                response: Response<CurrentWeatherResponse>
            ) {
                text.text = response.body().toString()
            }
        })*/
         GlobalScope.launch(Dispatchers.Main) {
             val currentWeatherResponse = apiService.getCurrentWeahter("London").await()
             text.text = currentWeatherResponse.toString()
         }
    }

}
