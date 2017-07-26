package com.example.toor.yamblzweather.presentation.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toor.yamblzweather.R;
import com.example.toor.yamblzweather.data.models.places.PlaceName;
import com.example.toor.yamblzweather.data.models.places.PlacesAutocompleteModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by igor on 7/25/17.
 */

public class CityNameAdapter extends android.support.v7.widget.RecyclerView.Adapter<CityNameAdapter.CityViewHolder>{

    PlacesAutocompleteModel data;

    private final PublishSubject<PlaceName> dataSubject = PublishSubject.create();

    public CityNameAdapter(PlacesAutocompleteModel data) {
        this.data = data;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_city_name, parent, false);
        CityViewHolder viewHolder = new CityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.cityName.setText(data.getPredictionAt(position).getName());
        holder.itemView.setOnClickListener(view -> dataSubject.onNext(data.getPredictionAt(position)));
    }

    @Override
    public int getItemCount() {
        if(data == null) {
            return 0;
        }
        return data.getSize();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cityName)
        TextView cityName;

        public CityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public Observable<PlaceName> getSelectedPlace() {
        return dataSubject;
    }
}
