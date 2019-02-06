package com.example.eltiempo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import org.w3c.dom.Text;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Forecast> mWeatherList;
    private LayoutInflater mInflater;
    private Context context;

    public WeatherAdapter(Context context, List<Forecast> weatherList){
        mInflater = LayoutInflater.from(context);
        this.mWeatherList = weatherList;
        this.context = context;

    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        public final TextView txtDate;
        public final TextView txtWindDirection;
        public final TextView txtWindSpeed;
        public final TextView txtMaxTemp;
        public final TextView txtTheTemp;
        public final TextView txtMinTemp;
        public final ImageView imgState;
        final WeatherAdapter mAdapter;

        public WeatherViewHolder(View itemView, WeatherAdapter adapter){
            super(itemView);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtWindDirection = itemView.findViewById(R.id.txtWindDirection);
            txtWindSpeed = itemView.findViewById(R.id.txtWindSpeed);
            txtMaxTemp = itemView.findViewById(R.id.txtMaxTemp);
            txtTheTemp = itemView.findViewById(R.id.txtTheTemp);
            txtMinTemp = itemView.findViewById(R.id.txtMinTemp);
            imgState = itemView.findViewById(R.id.imgState);
            this.mAdapter = adapter;
        }


    }

    public WeatherAdapter() {
        super();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position){
        View mItemView = mInflater
                .inflate(R.layout.forecast_item, parent, false);
        return new WeatherViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position){
        Forecast mCurrent = mWeatherList.get(position);
        weatherViewHolder.txtDate.setText(mCurrent.getApplicable_date());
        weatherViewHolder.txtWindDirection.setText(mCurrent.getWind_direction_compass());
        weatherViewHolder.txtWindSpeed.setText(mCurrent.getWind_speed().toString());
        weatherViewHolder.txtMaxTemp.setText(mCurrent.getMax_temp().toString());
        weatherViewHolder.txtTheTemp.setText(mCurrent.getThe_temp().toString());
        weatherViewHolder.txtMinTemp.setText(mCurrent.getMin_temp().toString());
        String url = "https://www.metaweather.com/static/img/weather/png/64/"+mCurrent.getWeather_state_abbr()+".png";
        Glide.with(context).load(url).into(weatherViewHolder.imgState);



    }

    @Override
    public int getItemCount() {
        if (mWeatherList == null){
            return 0;
        }

        return mWeatherList.size();

    }

    public void setData(List <Forecast> newList){
        mWeatherList = newList;
        notifyDataSetChanged();
    }
}
