package com.nbs.mvpsample.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nbs.mvpsample.R;

/**
 * Created by ghiyatshanif on 3/1/17.
 * purpose : factory for all message-regarding component like toast,snackbar and alert
 */

public class MessageFactory {

    public static ProgressDialog showLoadingDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.show();
//        if (progressDialog.getWindow() != null) {
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static ProgressDialog showCancellabeLoadingDialog(String message) {
        ProgressDialog progressDialog = new ProgressDialog(ContextProvider.get());
        progressDialog.setMessage(message);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        return progressDialog;
    }

    public static void showToast(String message) {
        Toast.makeText(ContextProvider.get(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String message) {
        Toast.makeText(ContextProvider.get(), message, Toast.LENGTH_LONG).show();
    }

    public static void showSnackbarMessage(View view, String message) {

        Snackbar snackbar = Snackbar.make(view,
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(ContextProvider.get(), R.color.colorAccent));
        snackbar.show();
    }

    public static void showSnackbarMessage(View view, String message, String actionName, View.OnClickListener actionListener) {
        Snackbar snackbar = Snackbar.make(view,
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(ContextProvider.get(), R.color.colorAccent));

        snackbar.setAction(actionName, actionListener);

        snackbar.show();
    }

    public static void showAlertDialog(String message) {
        new AlertDialog.Builder(ContextProvider.get())
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public static void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(ContextProvider.get())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    public static void showAlertDialog(String title
            , String message
            , String positive
            , DialogInterface.OnClickListener positiveListener) {

        new AlertDialog.Builder(ContextProvider.get())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, positiveListener).show();
    }

    public static void showAlertDialog(String title
            , String message
            , String positive
            , DialogInterface.OnClickListener positiveListener
            , String negative
            , DialogInterface.OnClickListener negattiveListener) {

        new AlertDialog.Builder(ContextProvider.get())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positive, positiveListener)
                .setNegativeButton(negative, negattiveListener)
                .show();
    }

}
