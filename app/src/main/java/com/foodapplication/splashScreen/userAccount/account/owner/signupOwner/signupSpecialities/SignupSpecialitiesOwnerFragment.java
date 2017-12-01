package com.foodapplication.splashScreen.userAccount.account.owner.signupOwner.signupSpecialities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.foodapplication.R;
import com.foodapplication.helper.FragmentChange;
import com.foodapplication.utils.FragmentUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupSpecialitiesOwnerFragment extends Fragment implements SignupSpecialitiesOwnerController.View, MyRecyclerViewAdapter.ItemClickListener ,TimePickerDialog.OnTimeSetListener{

    private int pickerHour = 0;
    private int pickerMin = 0;


    @BindView(R.id.txtCuisine)
    AppCompatTextView txtCuisine;
    @BindView(R.id.editTxtCuisine)
    TextInputEditText editTxtCuisine;
    @BindView(R.id.textInputLayoutCuisine)
    TextInputLayout textInputLayoutCuisine;
    @BindView(R.id.rvCuisine)
    RecyclerView rvCuisine;
    @BindView(R.id.editTxtSpeciality)
    TextInputEditText editTxtSpeciality;
    @BindView(R.id.textInputLayoutSpeciality)
    TextInputLayout textInputLayoutSpeciality;
    @BindView(R.id.rvSpecialities)
    RecyclerView rvSpecialities;
    @BindView(R.id.txtOpenTime)
    TextView txtOpenTime;
    @BindView(R.id.txtClosingTime)
    TextView txtClosingTime;
    @BindView(R.id.btnSignup)
    AppCompatButton btnSignup;
    @BindView(R.id.txtDontHave)
    AppCompatTextView txtDontHave;
    @BindView(R.id.txtLogin)
    AppCompatTextView txtLogin;
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    Unbinder unbinder;

    FragmentChange fragmentChange;
    FragmentActivity fragmentActivity;

    MyRecyclerViewAdapter adapter;
    ArrayList<String> specialities = new ArrayList<>();
    ArrayList<String> cusines = new ArrayList<>();


    public SignupSpecialitiesOwnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup_specialities_owner, container, false);
        unbinder = ButterKnife.bind(this, view);


        editTxtSpeciality.addTextChangedListener(onTextChangedListener(editTxtSpeciality));
        editTxtCuisine.addTextChangedListener(onTextChangedListener(editTxtCuisine));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.txtOpenTime, R.id.txtClosingTime, R.id.btnSignup, R.id.txtLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txtOpenTime:


                break;
            case R.id.txtClosingTime:

                break;
            case R.id.btnSignup:
                break;
            case R.id.txtLogin:
                break;
        }
    }


    private TextWatcher onTextChangedListener(EditText editText) {
        return new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence returnedResult, int start,
                                      int before, int count) {

                String result = returnedResult.toString();

                if (result.contains(",")) {
                    if (editText == editTxtSpeciality) {
                        specialities.add(result.substring(0, result.length() - 1));

                        setLayout(rvSpecialities, specialities);

                    }
                    if (editText == editTxtCuisine) {
                        cusines.add(result.substring(0, result.length() - 1));

                        setLayout(rvCuisine, cusines);
                    }

                    editText.setText("");
                    return;

                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        };


    }


    private void setLayout(RecyclerView rv, ArrayList<String> data) {
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new MyRecyclerViewAdapter(getActivity(), data, rv);
        adapter.setClickListener(this);
        if (data.size() > 0) {
            rv.removeView(rv.getRootView());
        }
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position, RecyclerView recyclerView) {
        if (recyclerView == rvCuisine) {
            cusines.remove(position);
            setLayout(recyclerView, cusines);
        }
        if (recyclerView == rvSpecialities) {
            specialities.remove(position);
            setLayout(recyclerView, specialities);
        }

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        pickerHour = hourOfDay;
        pickerMin = minute;

        System.out.println("time is "+pickerHour+":"+pickerMin);




    }
}
