package com.gura.step06fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    [Fragment만드는 방법]
    1. Fragment클래스를 상속받는다
    2.onCreateView()메소드를 오버라이딩한다.

 */
public class MyFragment extends Fragment
                        implements View.OnTouchListener {
    //터치 횟수를 관리할 필드
    private  int touchCount;
    //TextView의 참조값
    private TextView textView;
    //액티비티의 참조값을 MyFragmentListener type으로 사용하기
    private MyFragmentListener activity;
    //MyFragement를 사용할 액티비티구현할 리스너인터페이스
    public interface MyFragmentListener{
        public void showMessage(int count);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //인자로 전달되는 레이아웃 전개자 객체를 이용해서 View객체를 만들어서
        View view=inflater.inflate(R.layout.fragment_my,container);
        //TextView의 참조값 얻어오기
        textView=view.findViewById(R.id.textView);
        //TextView에 터치 리스너 등록하기
        textView.setOnTouchListener(this);
        //해당 프레그먼트를 관리하는 액티비티의 참조값
        FragmentActivity a=getActivity();
        //해당 액티비티가 MyFragementListner type이 맞으면
        if(a instanceof MyFragmentListener){
            //MyFragmentListener type으로 casting 한다.
            activity=(MyFragmentListener)a;
        }
        /*activity=(MainActivity) getActivity(); //★ 액티비티를 얻어서 강제로 mainActivity로 캐스팅 했기 때문에 액티비티 재사용을 하지 못한다.*/
        //리턴해준다.
        return view;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //1. 터치 카운트를 1 증가시킨다.
        touchCount++;
        //2. TextView에 출력하기
        textView.setText(Integer.toString(touchCount));
        //3. 액티비티의 메소드 호출하면서 카운트 전달하기
        if(touchCount%10==0 && activity !=null){
            activity.showMessage(touchCount);
        }
        return false;
    }
}
