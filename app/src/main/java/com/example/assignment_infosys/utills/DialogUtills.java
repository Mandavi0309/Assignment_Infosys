package com.example.assignment_infosys.utills;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.example.assignment_infosys.R;

public class DialogUtills {

    private static ProgressDialog _pd;

    public static void stopProgressDialog() {
        if (_pd != null) {
            _pd.dismiss();
        }
        _pd = null;
    }

    public static void showToast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void startProgressDialog(Context context, String message) {
        if (_pd == null) {
            _pd = ProgressDialog.show(context, null, null);
            _pd.setContentView(R.layout.layout_progress_dialog);
            _pd.setMessage(message);
            _pd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            _pd.setCancelable(false);
            _pd.show();
        }
    }
}
