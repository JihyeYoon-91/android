package com.gura.step01layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
          res/layout/activity_main.xml 문서를 전개(해석)해서 화면을 구성한다.
          xml문서에 있는 UI객체(View객체)가 각각 생성된다.

         */
        setContentView(R.layout.linear08);


            }
}
