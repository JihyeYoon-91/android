package com.gura.step03listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
                implements AdapterView.OnItemLongClickListener {
    //필드
    List<String> names;
    //선택한 셀 인덱스를 저장할 필드
    int selectedIndex;
    //ListView에 연결된 아답타의 참조값을 저장할 필드
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //ListView의 참조값 얻어오기
        ListView listView=findViewById(R.id.listView);


        names=new ArrayList<>();
        //모델에 sample데이터 저장
        for(int i=0;i<100; i++){
            names.add("김구라"+i);
        }

        //ListView에 연결할 어뎁터 객체 생성하기 여러개 목록을 생성하는 위젯
        adapter=new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        names);

        //listview에 어뎁터 연결할 모델(Data)
        listView.setAdapter(adapter);
        // 셀을 오랫동안 눌렀을 때 동작할 리스너 등록하기
        listView.setOnItemLongClickListener(this);
    }

    //AlertDialog버튼 클릭 리스너 객체
    DialogInterface.OnClickListener listener=
            new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int i) {
                    switch (i){
                        case DialogInterface.BUTTON_POSITIVE: //긍정 버튼을 눌렀을 때
                            //1.선택한 아이템 인덱스를 모델에서 삭제한다.
                            names.remove(selectedIndex);
                            //2.ListView를 업데이트 한다.(아답타를 이용해서)
                            adapter.notifyDataSetChanged();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE: //부정 버튼을 눌렀을 때
                            break;                    }
                }
            };

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {

        //선택한 인덱스를 필드에 저장한다.
        selectedIndex=i;
        new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage(names.get(i)+" 정보를 삭제하겠습니까?")
                    .setNegativeButton("아니오",listener)
                    .setPositiveButton("네",listener)
                    .create()
                    .show();
        return false;
    }
}
