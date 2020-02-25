package com.gura.step06fragment2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gura.step06fragment2.CountryDto;
import com.gura.step06fragment2.R;

import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    //ViewPager에 출력할 모델
    private List<CountryDto> countries;

    //생성자
    public SectionsPagerAdapter(List<CountryDto> countries, FragmentManager fm) {
        super(fm);
        this.countries=countries;
}
    //인자로 전달하는 인덱스에 해당하는 fragment객체의 참조값을 리턴해주는 ..메소드 뷰페이저가 호출할~~
    @Override
    public Fragment getItem(int position) {
        // position인덱스에 해당하는 CountryDto
        CountryDto dto=countries.get(position);
        //position인덱스에 해당하는 프레그먼트의 참조값 얻어내서
        PlaceholderFragment fr=PlaceholderFragment.newInstance(dto);
        //리턴해주기
        return fr;
    }
    //인자로 전달되는 인덱스에 해당하는 문자열(페이지제목,tab제목)을 리턴해주는 메소드
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //국가의 이름을 title로 사용하도록
        String title=countries.get(position).getName();
        return title;
    }

    @Override  //전체 페이지수를 리턴해준다.
    public int getCount() {
        // 전체 국가의 갯수 리턴
        return countries.size();
    }
}