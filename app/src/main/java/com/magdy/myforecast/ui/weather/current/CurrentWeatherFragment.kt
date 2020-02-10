package com.magdy.myforecast.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.magdy.myforecast.R
import com.magdy.myforecast.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(CurrentWeatherViewModel::class.java)
        bindUI()
        // TODO: Use the ViewModel
        /* val apiService = ApiService(ConnectivityInterceptorImpl(this.context!!))
         val weatherNetworkDataSourceImpl = WeatherNetworkDataSourceImpl(apiService)

         weatherNetworkDataSourceImpl.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
             text.text = it.toString()
         })
 */
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
        /* GlobalScope.launch(Dispatchers.Main) {
             weatherNetworkDataSourceImpl.fetchCurrentWeather("London", "m")
         }*/
    }

    private fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            text.text = it.toString()
        })
    }

}
