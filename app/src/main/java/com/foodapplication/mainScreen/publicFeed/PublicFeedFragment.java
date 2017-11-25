package com.foodapplication.mainScreen.publicFeed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFeedFragment extends Fragment implements PublicFeedController.View {


    public PublicFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_public_feed, container, false);
    }

}
