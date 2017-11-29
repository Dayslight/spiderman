package com.foodapplication.splashScreen.userAccount.client.signupClient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupClientFragment extends Fragment implements SignupClientController.View{

    SignupClientController.Presenter signupClientPresenter;



    public SignupClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        signupClientPresenter = new SignupClientPresenter(this);




        return inflater.inflate(R.layout.fragment_signup_owner, container, false);
    }


    @Override
    public void openNextScreen() {

    }

    @Override
    public void setPresenter(SignupClientController.Presenter presenter) {
        this.signupClientPresenter = presenter;
    }


}
