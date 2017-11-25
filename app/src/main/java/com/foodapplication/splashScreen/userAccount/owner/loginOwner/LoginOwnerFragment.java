package com.foodapplication.splashScreen.userAccount.owner.loginOwner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOwnerFragment extends Fragment implements LoginOwnerController.View{


    public LoginOwnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_owner, container, false);
    }

}
