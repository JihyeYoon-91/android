package com.gura.step04customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
/*        //DetailActivity가 활성화 되는데 사용되었던 Intent객체의 참조값 얻어오기
        Intent intent=getIntent();
        //"dto"라는 키값으로 담긴 Serializable type객체의 참조값 얻어오기
        Serializable serial=intent.getSerializableExtra("dto");
        //원래 type으로 casting!
        CountryDto dto=(CountryDto)serial;*/

        //위의 3줄을 1줄의 코드로 바꾸면...
        CountryDto dto=(CountryDto)getIntent().getSerializableExtra("dto");

        //전개된 레이아웃에서 UI참조값 얻어오기
        ImageView imageView=findViewById(R.id.imageView);
        TextView textView=findViewById(R.id.textView);
        Button confirmBtn=findViewById(R.id.confirmBtn);

        //이미지와 내용출력하기
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getContent());

        //버튼에 리스너 등록하기
        confirmBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //액티비티 종료 시키기 - mainactivity위에있던 detailactivity가 꺼지고 mainactivity가 드러난다.
        finish();
    }
}
