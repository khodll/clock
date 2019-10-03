package com.example.clockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeCities();
    }

    public void onClickHide(View view){
        Button hideButton = findViewById(R.id.hideButton);
//        View parentLayout=(View)hideButton.getParent().getParent();
        ConstraintLayout timeLayout=findViewById(R.id.timeLayout);
        if(timeLayout.getVisibility()==View.GONE){
            timeLayout.setVisibility(View.VISIBLE);
            hideButton.setText("-");
        }
        else{
            timeLayout.setVisibility(View.GONE);
            hideButton.setText("+");
        }
//        hideButton.setVisibility(View.VISIBLE);
    }

    public void getCurrentTime(){
        localTime=LocalTime.now();
        localTime2=LocalTime.now(ZoneId.of("Europe/London"));
        localTime3=LocalTime.now(ZoneId.of("Asia/Tokyo"));
        localTime4=LocalTime.now(ZoneId.of("Asia/Shanghai"));
        localTime5=LocalTime.now(ZoneId.of("America/New_York"));
    }
    public void onClick12Hour(View view){
        getCurrentTime();
        String twelveTime1=convertTo12(convertTimeString(localTime));
        String twelveTime2=convertTo12(convertTimeString(localTime2));
        String twelveTime3=convertTo12(convertTimeString(localTime3));
        String twelveTime4=convertTo12(convertTimeString(localTime4));
        String twelveTime5=convertTo12(convertTimeString(localTime5));

        LinearLayout cityChunk = findViewById(R.id.city1);
        LinearLayout cityChunk2 = findViewById(R.id.city2);
        LinearLayout cityChunk3 = findViewById(R.id.city3);
        LinearLayout cityChunk4 = findViewById(R.id.city4);
        LinearLayout cityChunk5= findViewById(R.id.city5);
        TextView cityTime = cityChunk.findViewById(R.id.cityTime);
        cityTime.setText(twelveTime1);
        TextView cityTime2 = cityChunk2.findViewById(R.id.cityTime);
        cityTime2.setText(twelveTime2);
        TextView cityTime3 = cityChunk3.findViewById(R.id.cityTime);
        cityTime3.setText(twelveTime3);
        TextView cityTime4 = cityChunk4.findViewById(R.id.cityTime);
        cityTime4.setText(twelveTime4);
        TextView cityTime5 = cityChunk5.findViewById(R.id.cityTime);
        cityTime5.setText(twelveTime5);
        //TODO: setCityTimes(String timeString)
        /*TODO: calculateTime(){
            calculate localTimes for each zone
            setCityTimes(convertTimeString(localTime for each zone))*/
        //TODO: onClick12Hour --> setCityTimes(convertTo12(localTime for each zone))
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
        setCityTimes(localTime);
        TextView cityName = cityChunk.findViewById(R.id.cityName);
        cityName.setText(R.string.city);
        ImageView cityPic = cityChunk.findViewById(R.id.cityPic);
        cityPic.setImageDrawable(getResources().getDrawable(R.drawable.sydney));
        //city 2
        TextView cityName2 = cityChunk2.findViewById(R.id.cityName);
        cityName2.setText(R.string.city2);
        ImageView cityPic2 = cityChunk2.findViewById(R.id.cityPic);
        cityPic2.setImageDrawable(getResources().getDrawable(R.drawable.london));
        //city 3
        TextView cityName3 = cityChunk3.findViewById(R.id.cityName);
        cityName3.setText(R.string.city3);
        ImageView cityPic3 = cityChunk3.findViewById(R.id.cityPic);
        cityPic3.setImageDrawable(getResources().getDrawable(R.drawable.tokyo));
        //city 4
        TextView cityName4 = cityChunk4.findViewById(R.id.cityName);
        cityName4.setText(R.string.city4);
        ImageView cityPic4 = cityChunk4.findViewById(R.id.cityPic);
        cityPic4.setImageDrawable(getResources().getDrawable(R.drawable.shanghai));

        //city 5
        TextView cityName5 = cityChunk5.findViewById(R.id.cityName);
        cityName5.setText(R.string.city5);
        ImageView cityPic5 = cityChunk5.findViewById(R.id.cityPic);
        cityPic5.setImageDrawable(getResources().getDrawable(R.drawable.newyork));
    }

    public void setCityTimes(LocalTime time){
        LinearLayout cityChunk = findViewById(R.id.city1);
        LinearLayout cityChunk2 = findViewById(R.id.city2);
        LinearLayout cityChunk3 = findViewById(R.id.city3);
        LinearLayout cityChunk4 = findViewById(R.id.city4);
        LinearLayout cityChunk5= findViewById(R.id.city5);
        TextView cityTime = cityChunk.findViewById(R.id.cityTime);
        cityTime.setText(convertTimeString(time));
        TextView cityTime2 = cityChunk2.findViewById(R.id.cityTime);
        cityTime2.setText(convertTimeString(localTime2));
        TextView cityTime3 = cityChunk3.findViewById(R.id.cityTime);
        cityTime3.setText(convertTimeString(localTime3));
        TextView cityTime4 = cityChunk4.findViewById(R.id.cityTime);
        cityTime4.setText(convertTimeString(localTime4));
        TextView cityTime5 = cityChunk5.findViewById(R.id.cityTime);
        cityTime5.setText(convertTimeString(localTime5));
    }

    public String convertTo12 (String time24){
        String[] timeSplit = time24.split(":");
        int hour=Integer.parseInt(timeSplit[0]);
        int minute=Integer.parseInt(timeSplit[1]);
        String minString="";
        if (minute<10){
            minString="0"+minute;
        }
        else{
            minString=timeSplit[1];
        }

        if (hour>12){
            return (hour-12)+":"+minString+"PM";
        }
        else if(hour==12){
            return hour+":"+minString+"PM";
        }
        else if(hour==0){
            return "12:"+minString+"AM";
        }
        else{
            return hour+":"+minString+"AM";
        }

    }

    public String convertTimeString(LocalTime time) {
        int hour=time.getHour();
        int minute=time.getMinute();
        String minString="";
        if (minute<10){
            minString="0"+minute;
        }
        else{
            minString=Integer.toString(minute);
        }
        return hour+":"+minString;

    }
}
