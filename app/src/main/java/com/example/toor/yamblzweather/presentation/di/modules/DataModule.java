package com.example.toor.yamblzweather.presentation.di.modules;

import android.content.Context;

import com.example.toor.yamblzweather.data.SettingsPreference;
import com.example.toor.yamblzweather.domain.providers.WeatherProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public SettingsPreference provideSettingsPreference(Context context) {
        return new SettingsPreference(context);
    }

    @Provides
    @Singleton
    public WeatherProvider provideWeatherProvider() {
        return new WeatherProvider();
    }
}
