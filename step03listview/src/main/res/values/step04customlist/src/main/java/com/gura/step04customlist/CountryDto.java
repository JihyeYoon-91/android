package com.gura.step04customlist;

import java.io.Serializable;
/*
        Intent객체에 putExtra()해서 담을 수 있도록
        Serializable 인터페이스를 구현시킨다.
 */
public class CountryDto implements Serializable {
    //필드
    private int resId; //drwable폴더의 사진 정수값이 담김
    private String name; //나라이름
    private String content; //나라설명
    //생성자
    public CountryDto(){}

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CountryDto(int resId, String name, String content) {
        this.resId = resId;
        this.name = name;
        this.content = content;
    }
}
