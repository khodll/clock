package com.example.clockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    LocalTime localTime=LocalTime.now();
    LocalTime localTime2=LocalTime.now(ZoneId.of("Europe/London"));
    LocalTime localTime3=LocalTime.now(ZoneId.of("Asia/Tokyo"));
    LocalTime localTime4=LocalTime.now(ZoneId.of("Asia/Shanghai"));
    LocalTime localTime5=LocalTime.now(ZoneId.of("America/New_York"));
    City sydney = new City(LocalTime.now(),"Sydney");
    City london = new City(localTime2,"London");
    City tokyo = new City(localTime3,"Tokyo");
    City shanghai = new City(localTime4,"Shanghai");
    City newyork = new City(localTime5, "New York");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeCities();
    }

    public void onClickHide(View view){
        View parentLayout=(View)view.getParent().getParent();
        ConstraintLayout timeLayout=parentLayout.findViewById(R.id.timeLayout);
        Button hideButton = parentLayout.findViewById(R.id.hideButton);
        if(timeLayout.getVisibility()==View.GONE){
            timeLayout.setVisibility(View.VISIBLE);
            hideButton.setText("-");
        }
        else{
            timeLayout.setVisibility(View.GONE);
            hideButton.setText("+");
        }
    }

    public void getCurrentTime(){
        localTime=LocalTime.now();
        sydney.setTime(localTime);
        localTime2=LocalTime.now(ZoneId.of("Europe/London"));
        london.setTime(localTime2);
        localTime3=LocalTime.now(ZoneId.of("Asia/Tokyo"));
        tokyo.setTime(localTime3);
        localTime4=LocalTime.now(ZoneId.of("Asia/Shanghai"));
        shanghai.setTime(localTime4);
        localTime5=LocalTime.now(ZoneId.of("America/New_York"));
        newyork.setTime(localTime5);
    }
    public void onClick12Hour(View view){
        getCurrentTime();

        LinearLayout cityChunk = findViewById(R.id.city1);
        LinearLayout cityChunk2 = findViewById(R.id.city2);
        LinearLayout cityChunk3 = findViewById(R.id.city3);
        LinearLayout cityChunk4 = findViewById(R.id.city4);
        LinearLayout cityChunk5= findViewById(R.id.city5);
        setView(cityChunk,"Sydney",sydney.getTime12());
        setView(cityChunk2,"London",london.getTime12());
        setView(cityChunk3,"Tokyo",tokyo.getTime12());
        setView(cityChunk4,"Shanghai",shanghai.getTime12());
        setView(cityChunk5,"New York",newyork.getTime12());

    }
    public void onClick24Hour(View view){
        changeCities();
    }
    public void changeCities(){
        getCurrentTime();

        LinearLayout cityChunk = findViewById(R.id.city1);
        LinearLayout cityChunk2 = findViewById(R.id.city2);
        LinearLayout cityChunk3 = findViewById(R.id.city3);
        LinearLayout cityChunk4 = findViewById(R.id.city4);
        LinearLayout cityChunk5= findViewById(R.id.city5);
        setCityTimes();
        ImageView cityPic = cityChunk.findViewById(R.id.cityPic);
        cityPic.setImageDrawable(getResources().getDrawable(R.drawable.sydney));
        //city 2
        ImageView cityPic2 = cityChunk2.findViewById(R.id.cityPic);
        cityPic2.setImageDrawable(getResources().getDrawable(R.drawable.london));
        //city 3
        ImageView cityPic3 = cityChunk3.findViewById(R.id.cityPic);
        cityPic3.setImageDrawable(getResources().getDrawable(R.drawable.tokyo));
        //city 4
        ImageView cityPic4 = cityChunk4.findViewById(R.id.cityPic);
        cityPic4.setImageDrawable(getResources().getDrawable(R.drawable.shanghai));
        //city 5
        ImageView cityPic5 = cityChunk5.findViewById(R.id.cityPic);
        cityPic5.setImageDrawable(getResources().getDrawable(R.drawable.newyork));
    }

    public void setCityTimes(){
        LinearLayout cityChunk = findViewById(R.id.city1);
        LinearLayout cityChunk2 = findViewById(R.id.city2);
        LinearLayout cityChunk3 = findViewById(R.id.city3);
        LinearLayout cityChunk4 = findViewById(R.id.city4);
        LinearLayout cityChunk5= findViewById(R.id.city5);
        setView(cityChunk,"Sydney",sydney.getTime24());
        setView(cityChunk2,"London",london.getTime24());
        setView(cityChunk3,"Tokyo",tokyo.getTime24());
        setView(cityChunk4,"Shanghai",shanghai.getTime24());
        setView(cityChunk5,"New York",newyork.getTime24());

    }

    public void setView(LinearLayout chunk, String cityName, String time){
        TextView cityTime=chunk.findViewById(R.id.cityTime);
        TextView name=chunk.findViewById(R.id.cityName);
        cityTime.setText(time);
        name.setText(cityName);
    }


}
