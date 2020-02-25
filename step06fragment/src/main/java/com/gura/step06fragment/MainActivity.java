package com.gura.step06fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements MyFragment.MyFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //만일 activity_main.xml에 정의된  fragment객체의 참조값이 Activity 에서 필요하다면?
        FragmentManager fm=getSupportFragmentManager();
        MyFragment myFragment=(MyFragment)fm.findFragmentById(R.id.myFragment);
    }
    //버튼을 눌렀을 때 호출되는 메소드
    public void move(View v){
        Intent i=new Intent(this,SubActivity.class);
        startActivity(i);
    }
    //MyFragement가 호출하는 메소드
    @Override
    public void showMessage(int count) {
        Toast.makeText(this,"현재카운트:" +count,
                Toast.LENGTH_LONG).show();
    }
    //프레그먼트가 호출할 메소드

   /*
        [Fragment 만드는 방법]
        1.Fragment클래스를 상속받는다.
        2.onCreateView()메소들르 오버라이드 한다.
     *//*
    //fragment : 재 사용성을 염두해둔 미니 컨트롤러의 역활
    //ex)웹페이지에 여러내용중 이미지 슬라이더만 따로 만드는 경우
    //ex)여러 액티비티에서 공동으로 사용하는 경우 따로 만들어놓으면 편하니까
    public static class MyFragment extends Fragment{
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
            //인자로 전달되는 레이아웃 전개자 객체를 이용해서 View객체를 만들어서
            View view=inflater.inflate(R.layout.fragment_my,container);
            //리턴해주어야한다.
           return view;
        }
    }*/
}
