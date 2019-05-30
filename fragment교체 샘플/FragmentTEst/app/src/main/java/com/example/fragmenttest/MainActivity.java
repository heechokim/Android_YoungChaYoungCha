package com.example.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3;
    FragmentManager fm;
    FragmentTransaction tran;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        setFragment(0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                setFragment(0);
                break;
            case R.id.btn2:
                setFragment(1);
                break;
            case R.id.btn3:
                setFragment(2);
                break;
        }
    }

    public void setFragment(int n){
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        switch(n){
            case 0:
                tran.replace(R.id.framelayout_right, fragment1);
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.framelayout_right, fragment2);
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.framelayout_right, fragment3);
                tran.commit();
                break;
        }
    }
}
/** 메인 엑티비티 자바 파일 작성하기
 * 1. activity.xml 의 버튼 3개를 선언한다.
 * 2. 프래그먼트 매니저를 선언한다.
 * 3. 프래그먼트 Transaction 을 선언한다.
 * 4. 각 프래그먼트 플래스를 선언한다.
 * 5. 각 버튼을 객체화 시킨다.
 * 6. onClickListener 을 implement 하고, onClick 함수를 오버라이딩 한다.
 * 7. 각 버튼에 클릭 리스너를 set 시킨다.
 * 8. onCreate 함수 안에 switch 문을 작성한다. v 는 이 리스너가 적용된 각 버튼이다.
 * 9. 선언만했던 프래그먼트 클래스를 초기화 시켜준다.
 * 10. setFragment 라는 사용자 함수를 만든다. 이 함수 안에서 프래그먼트 매니저와
 * transaction 을 초기화 해준다.(transaction은 프래그먼트를 교체할 때 마다 새로 초기화 해줘야 한다.)
 * 또 이 함수안에서 프래임레이아웃에 프레그 먼트를 바꿔주는 코드를 작성해준다.
 * 11. 아까 작성했던 버튼의 onClick 함수에 setFragment() 함수를 호출시켜준다. */
