package com.pyz.navigationbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup navigationBar;
    private RadioButton btn1, btn2, btn3, btn4;
    private Fragment fragment1, fragment2, fragment3, fragment4;

    private Fragment mFragment;//当前显示的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_fragment,fragment1).commit();
        mFragment = fragment1;
    }

    private void initViews() {
        navigationBar = (RadioGroup) findViewById(R.id.navigation_btn);
        btn1 = (RadioButton) findViewById(R.id.btn1);
        btn2 = (RadioButton) findViewById(R.id.btn2);
        btn3 = (RadioButton) findViewById(R.id.btn3);
        btn4 = (RadioButton) findViewById(R.id.btn4);
        navigationBar.setOnCheckedChangeListener(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.btn1:
                btn1.setChecked(true);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment1);
                break;
            case R.id.btn2:
                btn1.setChecked(false);
                btn2.setChecked(true);
                btn3.setChecked(false);
                btn4.setChecked(false);
                switchFragment(fragment2);

                break;
            case R.id.btn3:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(true);
                btn4.setChecked(false);
                switchFragment(fragment3);

                break;
            case R.id.btn4:
                btn1.setChecked(false);
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(true);
                switchFragment(fragment4);

                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment)
                        .add(R.id.main_fragment,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

}
