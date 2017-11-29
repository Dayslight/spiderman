package com.foodapplication.splashScreen.userAccount.client.signupClient;

import com.foodapplication.utils.GuavaUtil;

/**
 * Created by bijaybogati on 11/25/17.
 */

public class SignupClientPresenter implements SignupClientController.Presenter {

    SignupClientController.View mSignUpView;



    SignupClientPresenter(SignupClientController.View mSignUpView){
        this.mSignUpView = GuavaUtil.checkNotNull(mSignUpView);
        mSignUpView.setPresenter(this);

    }






    @Override
    public void signUp(String name) {

        mSignUpView.openNextScreen();
    }
}
