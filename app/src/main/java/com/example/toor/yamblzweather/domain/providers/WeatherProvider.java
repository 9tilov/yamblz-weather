package com.example.toor.yamblzweather.domain.providers;

import com.example.toor.yamblzweather.data.model.weather.gson.common.Coord;
import com.example.toor.yamblzweather.data.model.weather.gson.current_day.CurrentWeather;
import com.example.toor.yamblzweather.domain.service.OWService;

import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;

public class WeatherProvider {

    @Inject
    OWService service;

    public WeatherProvider(OWService service) {
        this.service = service;
    }

    public void setLanguage(Locale locale) {
        service.setLanguage(locale);
    }

    public Observable<CurrentWeather> getCurrentForecast(Coord coordinates) {
        return service.getCurrentDayForecast(coordinates);
    }
}
