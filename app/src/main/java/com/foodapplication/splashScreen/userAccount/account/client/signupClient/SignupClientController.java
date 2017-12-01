package com.foodapplication.splashScreen.userAccount.account.client.signupClient;

/**
 * Created by bijaybogati on 11/25/17.
 */

public interface SignupClientController {


    interface View{

        void openNextScreen();

        void setPresenter(Presenter presenter);

    }


    interface Presenter{


        void signUp(String name);


    }
}
