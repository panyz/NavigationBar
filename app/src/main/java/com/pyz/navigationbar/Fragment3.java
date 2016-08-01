package com.pyz.navigationbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: pyz
 * @Package: com.pyz.navigationbar
 * @Description: TODO
 * @Project: NavigationBar
 * @Date: 2016/8/1 14:23
 */
public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3_layout, container, false);
    }
}
