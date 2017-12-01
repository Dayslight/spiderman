package com.foodapplication.splashScreen.userAccount.account;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.foodapplication.R;
import com.foodapplication.helper.FragmentChange;
import com.foodapplication.splashScreen.userAccount.account.owner.signupOwner.SignupOwnerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountHandleActivity extends AppCompatActivity implements FragmentChange {

    @BindView(R.id.mainContainer)
    FrameLayout mainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_handle);
        ButterKnife.bind(this);


        Fragment signUpOwnerFragment = new SignupOwnerFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainContainer, signUpOwnerFragment).commit();


    }

    @Override
    public void replaceFragment(Fragment fragment, boolean replace, boolean addToBackStack, boolean clearBackStack, boolean animate) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (animate) {
//            fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        }
        if (replace) {
            fragmentTransaction.replace(R.id.mainContainer, fragment, fragment.toString());
        } else {
            fragmentTransaction.add(R.id.mainContainer, fragment, fragment.toString());
        }

        if (clearBackStack) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(fragment.toString());
            }
        }

        fragmentTransaction.commit();
    }
}
