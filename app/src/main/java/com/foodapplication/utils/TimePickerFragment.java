package com.foodapplication.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import com.foodapplication.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog


        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_LIGHT
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, hour, minute, false);

//        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_DARK
//        TimePickerDialog tpd2 = new TimePickerDialog(getActivity(),
//                AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,hour,minute,false);
//
//        // TimePickerDialog Theme : THEME_HOLO_DARK
//        TimePickerDialog tpd3 = new TimePickerDialog(getActivity(),
//                AlertDialog.THEME_HOLO_DARK,this,hour,minute,false);
//
//        // TimePickerDialog Theme : THEME_HOLO_LIGHT
//        TimePickerDialog tpd4 = new TimePickerDialog(getActivity(),
//                AlertDialog.THEME_HOLO_LIGHT,this,hour,minute,false);
//
//        // TimePickerDialog Theme : THEME_TRADITIONAL
//        TimePickerDialog tpd5 = new TimePickerDialog(getActivity(),
//                AlertDialog.THEME_TRADITIONAL,this,hour,minute,false);


//        return new TimePickerDialog(getActivity(),this, hour, minute,
//                DateFormat.is24HourFormat(getActivity()));
        return tpd;
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Do something with the user chosen time
        //Get reference of host activity (XML Layout File) TextView widget
        TextView txtOpenTime = (TextView) getActivity().findViewById(R.id.txtOpenTime);
        //Set a message for user
//        btn.setText("opening time is...\n");
        //Display the user changed time on TextView
        txtOpenTime.setText(String.valueOf(hourOfDay)
                + ": " + String.valueOf(minute));
    }
}