package com.rehammetwally.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    private Button showPopupWindow;
    private PopupWindow popupWindow;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPopupWindow = findViewById(R.id.showPopupWindow);
        linearLayout = findViewById(R.id.linearLayout);
        showPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup_window, null);
                popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(showPopupWindow, Gravity.CENTER,0,0);

                showPopupWindow.setVisibility(View.GONE);

//                popupWindow = new PopupWindow(getApplicationContext());
//                popupWindow.setContentView(popupView);
//                popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
//                popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

//                popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//                // Set popup window animation style.
////                popupWindow.setAnimationStyle(R.style.p);
//
//                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//
//                popupWindow.setFocusable(true);
//
//                popupWindow.setOutsideTouchable(true);
//
//                popupWindow.update();
//
//                // Show popup window offset 1,1 to smsBtton.
////                popupWindow.showAsDropDown(showPopupWindow, 1, 1);
//                popupWindow.showAtLocation(showPopupWindow, Gravity.CENTER, 0, 0);
                Button close =popupView.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        showPopupWindow.setVisibility(View.VISIBLE);
                    }
                });


            }
        });
    }
}
