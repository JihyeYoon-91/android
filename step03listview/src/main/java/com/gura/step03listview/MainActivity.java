package com.gura.step03listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity //부모타입중 context있음
        implements AdapterView.OnItemClickListener {

    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView의 참조값 얻어오기
        ListView listView=findViewById(R.id.listView);
        //어뎁터 연결할 모델(Data)                      Ul로 구성된 객체중에서 listView라는 아이디를
                                                        //아이디를 가지고있는 UI의 참조값 얻어오기

        names=new ArrayList<>();
        //모델에 sample데이터 저장
        for(int i=0;i<100; i++){
            names.add("김구라"+i);
        }

        //ListView에 연결할 어뎁터 객체 생성하기 여러개 목록을 생성하는 위젯
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    names);

        //ListView에 어뎁터 연결하기
        listView.setAdapter(adapter);
        //ListView에 아이템 클릭 리스너 등록하기
        listView.setOnItemClickListener(this);//this에 대한 이해가 필요하다 앞으로 많이나온다.
    }

    @Override //클릭한 셀에대한 정보가 넘어간다.
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        //인자로 전달되는 i에는 클릭한 인덱스값이 들어있다.
/*        new AlertDialog.Builder(this)
                .setMessage(names.get(i))
                .setNeutralButton("확인",null)
                .create()
                .show();*/
        AlertDialog.Builder builder=new AlertDialog.Builder(this); //아이템을 클릭할 때마다 뜨게
        builder.setMessage(names.get(i));
        builder.setNeutralButton("확인",null);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    //다음예제버튼을 눌렀을 때 호출되는 메소드
    public void moveNext(View v){
        //Main2Activity로 이동할 의도 객체 생성
        Intent i= new Intent(this,Main2Activity.class);
        //startActivity()메소드 호출하면서 의도객체를 전달하면 이동된다.
        startActivity(i);
    }

}
