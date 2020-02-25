package com.gura.step06fragment2.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.gura.step06fragment2.CountryDto;
import com.gura.step06fragment2.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    //Fragment객체를 생성해서 리턴해주는 static 메소드
    public static PlaceholderFragment newInstance(CountryDto dto) {
        PlaceholderFragment fr=new PlaceholderFragment();
        //Fragment에 전달할 Bundle객체 //담아주는 역활
        Bundle bundle=new Bundle();
        bundle.putSerializable("dto",dto);
        //Fragment에 인자 전달하기
        fr.setArguments(bundle);
        return fr;
    }
    //국가정보를 담을 필드
    private CountryDto dto;

    //1. 프레그먼트가 최초 사용될 때 호출되는 메소드(액티비티 실행 시 최초에 한번만 사용된다.)한번에 다 만들어놓고 사용한다.
    @Override   //호출순서1 프레그먼트 5개 객체에 각각 onCreate메소드가 한번씩 호출된다.
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //인자로 Bundle객체가 전달된다.
        dto=(CountryDto)getArguments().getSerializable("dto");//Serializable타입을 CountryDto타입으로 캐스팅
    }
    //2. 프레그먼트가 활성화 될 때마다 호출되는 메소드 중복해서 사용된다.
    @Override  //호출순서2
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        //res/layout/fragment_main.xml문서를 전개해서 View객체를 만든다.
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        //이미지 뷰의 참조값을 얻어와서
        ImageView imageView=view.findViewById(R.id.imageView);
        TextView textView=view.findViewById(R.id.textView);
        //이미지 출력하기
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getContent());
        //View객체 리턴해주기
        return view;
    }
}