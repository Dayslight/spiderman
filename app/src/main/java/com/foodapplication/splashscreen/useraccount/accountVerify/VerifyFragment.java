package com.foodapplication.splashscreen.useraccount.accountVerify;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyFragment extends Fragment implements VerifyController.View{


    public VerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify, container, false);
    }

}
