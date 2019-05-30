package com.example.fragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_right1, container, false);
        return view;
    }
}


/** 프래그 먼트 자바 클래스 만들기
 * 1. Fragment 를 상속받는다.
 * 2. onCreateView 함수를 오버라이딩 받는다.
 * 3. View 변수를 선언하고 onCreateView 함수 안에서 view 변수에 fragment.xml 을 인플레이트 시킨다. */