package com.gura.step04customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    //필드 정의하기
    ListView listView;
    List<CountryDto> countries;
    CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        countries=new ArrayList<>();
        countries.add(new CountryDto(R.drawable.austria,
                "오스트리아","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.belgium,
                "벨기에","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.brazil,
                "브라질","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.france,
                "프랑스","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.germany,
                "독일","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.greece,
                "그리스","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.israel,
                "이스라엘","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.italy,
                "이태리","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.japan,
                "일본","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.korea,
                "한국","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.poland,
                "폴란드","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.spain,
                "스페인","어쩌구..저쩌구.."));
        countries.add(new CountryDto(R.drawable.usa,
                "미국","어쩌구..저쩌구.."));

        //어댑터 객체 생성
        adapter=new CountryAdapter(this, //컨트리어뎁터는 베이스어뎁터를 상속받았기에 가능하다.
                R.layout.listview_cell,countries); //list 입장에서 adapter는 cell view의 공급자
        //어댑터를 ListView에 연결하기
        listView.setAdapter(adapter);
        //ListView에 아이템 클릭 리스너 등록하기
        listView.setOnItemClickListener(this);
    }
        //액티비티를 활성화시키기위해서는 intent객체가 필요한데 intent객체의 정보를 읽어와서 ~~
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Intent객체 생성하기
        Intent intent=new Intent(this,DetailActivity.class);
        //클릭한 아이템에 해당하는 국가정보를 읽어온다.
        CountryDto dto=countries.get(i);
        //국가정보를 Intent객체에 "dto"라는 키값으로 담고싶어요!!(serializable 타입으로 만든다)
        //serializable은 모양은 인터페이스타입이지만 안이 비어있어서 타입의 역활만 한다.
        intent.putExtra("dto",dto);
        //액티비티 이동
        startActivity(intent);
    }
}
