package com.foodapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.foodapplication.helper.Constants;

public class UserInterfaceUtil {
    @RequiresApi(api = Build.VERSION_CODES.M)
    static void showPermissionInfo(Context context, String title, String body, final Activity activity, final String permission) {
        new MaterialDialog.Builder(context)
                .title(title)
                .content(body)
                .positiveText("ok")
                .negativeText("cancel")
                .onPositive((dialog, which) -> {
                    SharedPreferences.Editor editor = PreferenceUtil.getPreferenceEditor(context);
                    if (PreferenceUtil.getSharedPreference(context).contains("PERMISSION")) {
                        String permissionString = PreferenceUtil.getSharedPreference(context).getString("PERMISSION", "");
                        if (permissionString.contains(permission)) {
                            dialog.dismiss();
                            openAppSettings(context);
                        } else {
                            editor.putString("PERMISSION", permissionString + "," + permission);
                            editor.apply();
                            dialog.dismiss();
                            activity.requestPermissions(new String[]{permission}, Constants.REQUEST_CODE_ASK_PERMISSIONS);
                        }
                    } else {
                        editor.putString("PERMISSION", permission);
                        editor.apply();
                        dialog.dismiss();
                        activity.requestPermissions(new String[]{permission}, Constants.REQUEST_CODE_ASK_PERMISSIONS);
                    }
                })
                .onNegative((dialog, which) -> dialog.dismiss())
                .show();
    }

//    public static void showSnackBar(Context context, CoordinatorLayout coordinatorLayout, String message, boolean action, String buttonText,
//                                    int snackBarLength, SnackBarAction snackBarAction) {
//        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, snackBarLength);
//        if (action) {
//            snackbar.setActionTextColor(ResourceUtil.getColor(context, R.color.colorAccentAlt));
//            snackbar.setAction(buttonText, view -> snackBarAction.action());
//        }
//        snackbar.show();
//    }

    public static MaterialDialog runProgressDialog(Context context, String title, String body) {
        final MaterialDialog progressDialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(body)
                .progress(true, 0)
                .show();
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }

//    public static void showNetworkError(Context context) {
//        new MaterialDialog.Builder(context)
//                .title(R.string.network_error)
//                .content(R.string.network_error_body)
//                .positiveText(R.string.button_ok)
//                .onPositive((materialDialog, dialogAction) -> materialDialog.dismiss())
//                .show();
//    }

//    public static void showInfoDialog(Context context, String title, String body, MyDialogAction myDialogAction) {
//        new MaterialDialog.Builder(context)
//                .title(title)
//                .content(body)
//                .positiveText(R.string.button_ok)
//                .onPositive((materialDialog, dialogAction) -> myDialogAction.onOk(materialDialog))
//                .show();
//    }

//    public static void showPersistentInfoDialog(Context context, String title, String body, MyDialogAction myDialogAction) {
//        new MaterialDialog.Builder(context)
//                .title(title)
//                .content(body)
//                .autoDismiss(false)
//                .positiveText(R.string.button_ok)
//                .onPositive((materialDialog, dialogAction) -> myDialogAction.onOk(materialDialog))
//                .show();
//    }

//    public static void showBalanceError(Context context) {
//        showInfoDialog(context, ResourceUtil.getString(context, R.string.error),
//                ResourceUtil.getString(context, R.string.low_balance_error), new MyDialogAction() {
//                    @Override
//                    public void onOk(MaterialDialog materialDialog) {
//                        materialDialog.dismiss();
//                    }
//
//                    @Override
//                    public void onCancel(MaterialDialog materialDialog) {
//
//                    }
//                });
//    }

//    public static void showServiceConfirmationDialog(Context context, String title, String iconUrl, String toLabel, String to, String amount, ConfirmDialogAction confirmDialogAction) {
//        Dialog confirmationDialog = new Dialog(context);
//        confirmationDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        confirmationDialog.setContentView(R.layout.dialog_payment_confirmation);
//        confirmationDialog.getWindow().setLayout(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
//        confirmationDialog.setCanceledOnTouchOutside(false);
//        confirmationDialog.setCancelable(false);
//        confirmationDialog.show();
//
//        RobotoBoldTextView tvServiceName = (RobotoBoldTextView) confirmationDialog.findViewById(R.id.tvServiceName);
//        ImageView ivServiceLogo = (ImageView) confirmationDialog.findViewById(R.id.ivServiceLogo);
//        RobotoTextView tvToLabel = (RobotoTextView) confirmationDialog.findViewById(R.id.tvToLabel);
//        RobotoTextView tvTo = (RobotoTextView) confirmationDialog.findViewById(R.id.tvTo);
//        RobotoTextView tvAmount = (RobotoTextView) confirmationDialog.findViewById(R.id.tvAmount);
//        LinearLayout llOk = (LinearLayout) confirmationDialog.findViewById(R.id.llOk);
//        LinearLayout llCancel = (LinearLayout) confirmationDialog.findViewById(R.id.llCancel);
//
//        if (EmptyUtil.isNotNull(toLabel)) {
//            tvToLabel.setText(toLabel);
//        }
//        tvServiceName.setText(title);
//        tvTo.setText(to);
//        tvAmount.setText(amount);
//        GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder = Glide.with(context)
//                .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
//                .from(Uri.class)
//                .as(SVG.class)
//                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
//                .sourceEncoder(new StreamEncoder())
//                .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
//                .decoder(new SvgDecoder())
//                .placeholder(R.mipmap.khalti_logo_b)
//                .error(R.mipmap.khalti_logo_b)
//                .listener(new SvgSoftwareLayerSetter<>());
//
//        Uri uri = Uri.parse(iconUrl);
//        requestBuilder
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .load(uri)
//                .into(ivServiceLogo);
//
//        llOk.setOnClickListener(view -> {
//            confirmationDialog.dismiss();
//            confirmDialogAction.onOk();
//        });
//        llCancel.setOnClickListener(view -> confirmationDialog.dismiss());
//    }

    public static void showToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    private static void openAppSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }

    /*Interfaces*/
    public interface MyDialogAction {
        void onOk(MaterialDialog materialDialog);

        void onCancel(MaterialDialog materialDialog);
    }

    public interface ConfirmDialogAction {
        void onOk();
    }

    public interface SnackBarAction {
        void action();
    }

    public interface UnlockInterface {

        void onSuccess();

        void onDismiss();

    }
}
