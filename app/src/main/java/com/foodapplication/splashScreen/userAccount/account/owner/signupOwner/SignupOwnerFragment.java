package com.foodapplication.splashScreen.userAccount.account.owner.signupOwner;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodapplication.R;
import com.foodapplication.helper.FragmentChange;
import com.foodapplication.splashScreen.userAccount.account.owner.signupOwner.signupSpecialities.SignupSpecialitiesOwnerFragment;
import com.foodapplication.utils.AppPermissionUtil;
import com.foodapplication.utils.FragmentUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupOwnerFragment extends Fragment implements SignupOwnerController.View, AppPermissionUtil.MyPermission {


    @BindView(R.id.resturantImageView)
    CircleImageView resturantImageView;
    @BindView(R.id.txtShortDescription)
    AppCompatTextView txtShortDescription;
    @BindView(R.id.edtRestaurantName)
    TextInputEditText edtRestaurantName;
    @BindView(R.id.textInputLayoutRestaurantName)
    TextInputLayout textInputLayoutRestaurantName;
    @BindView(R.id.edtEmail)
    TextInputEditText edtEmail;
    @BindView(R.id.textInputLayoutEmail)
    TextInputLayout textInputLayoutEmail;
    @BindView(R.id.imgNext)
    AppCompatImageView imgNext;
    @BindView(R.id.txtDontHave)
    AppCompatTextView txtDontHave;
    @BindView(R.id.txtSignup)
    AppCompatTextView txtSignup;
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;

    FragmentManager fragmentManager;
    Fragment fragment;

    Unbinder unbinder;
    FragmentChange fragmentChange;
    FragmentActivity fragmentActivity;


    public SignupOwnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup_owner, container, false);
        unbinder = ButterKnife.bind(this, view);
        this.fragmentActivity = getActivity();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void selectImage() {


        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {


                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";

                    System.out.println("*******R*******take photo selected");
                    cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";

                    System.out.println("*******R*******Gallery selected");
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    System.out.println("*******R*******cancel selected");
                    dialog.dismiss();
                }


            }
        });
        builder.show();
    }

    private void cameraIntent() {
        System.out.println("*******R*******open camera");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        System.out.println("*******R*******open gallery");
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        resturantImageView.setImageBitmap(bm);
    }


    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        resturantImageView.setImageBitmap(thumbnail);
    }


    @Override
    public void onPermission() {
        selectImage();


    }


    @OnClick({R.id.resturantImageView, R.id.imgNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resturantImageView:
                AppPermissionUtil.askPermission(getActivity(), "android.permission.CAMERA", "You Should Give Camera Permission!!", SignupOwnerFragment.this);

                break;
            case R.id.imgNext:
                FragmentUtil.openFragment(fragmentActivity, new SignupSpecialitiesOwnerFragment(), true, true, false, true, null);
//                fragment = new SignupSpecialitiesOwnerFragment();
//                fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().addToBackStack("home").replace(R.id.mainContainer, fragment).commit();
                break;
        }
    }

}
