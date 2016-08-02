
### **前言** ###
在写这个Demo的时候，是为了复习下Fragment的基础用法。不过就单纯地写Fragment又好像有点单一，于是我就想通过Fragment+RadioButton实现一个简单的底部导航栏。因为这样的布局在很多项目中都已经常用的。而且平时自己在学习其他技术点的时候，敲代码写Demo，也是用这样的基础布局来练习，一是由于Fragment的
轻量级，响应速度比较快，二是可以通过比较不同的Fragment，来体现你要学习的技术点的效果，这一点还是比较方便的。

### **Fragment的使用** ###
Fragment的使用？现在以我的水平肯定是写得不如其他人好，而且随便百度，google一下资源，也是一大把的。对于还不太熟悉Fragment的使用，可以看看鸿洋大神写的这篇博客
 [Android Fragment 你应该知道的一切](http://blog.csdn.net/lmj623565791/article/details/42628537)


### **coding time** ###
1. 把主布局搞好
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.pyz.navigationbar.MainActivity">

    <FrameLayout
        android:id="@+id/main_fragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1">

    </FrameLayout>


    <RadioGroup
        android:id="@+id/navigation_btn"
        android:layout_width="match_parent"
        android:layout_height="?actionBarSize"
        android:orientation="horizontal">

        <RadioButton
            android:id="@+id/btn1"
            android:text="Fragmnet1"
            android:gravity="center"
            android:button="@null"
            android:checked="true"
            android:background="@drawable/navigation_bar_selector"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"/>

        <RadioButton
            android:id="@+id/btn2"
            android:text="Fragmnet2"
            android:gravity="center"
            android:button="@null"
            android:background="@drawable/navigation_bar_selector"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"/>

        <RadioButton
            android:id="@+id/btn3"
            android:text="Fragmnet3"
            android:gravity="center"
            android:button="@null"
            android:layout_width="0dp"
            android:background="@drawable/navigation_bar_selector"
            android:layout_height="match_parent"
            android:layout_weight="1"/>

        <RadioButton
            android:id="@+id/btn4"
            android:text="Fragmnet4"
            android:gravity="center"
            android:button="@null"
            android:layout_width="0dp"
            android:background="@drawable/navigation_bar_selector"
            android:layout_height="match_parent"
            android:layout_weight="1"/>

    </RadioGroup>
</LinearLayout>
```
2. 在drawable文件下创建RadioButton的样式文件(这里我直接用颜色区分，可以根据情况选择用一些图片上去的)
```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:drawable="@color/colorAccent" android:state_checked="true"/>
    <item android:drawable="@color/colorAccent" android:state_pressed="true"/>
    <item android:drawable="@color/colorAccent" android:state_selected="true"/>
    <item android:drawable="@color/colorWhite"/>

</selector>
```

3. 创建4个Fragment（这个根据自己情况创建吧），然后创建相应的布局。（嗯，介个很简单d） 
4. 在MainActivity中实例化各个Fragment和RadioButton和RadioParent的控件，设置好监听器。在这里我定义了一个switchFragment（）的方法，判断切换的Fragment是否已经添加过，避免每一次切换Fragment的时候都调用add（）或者replace()，而是通过hide（）和show（），减少频繁地创建新的实例。
```java
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
```

5. 最后的效果图是这样滴
![NavigationBar](http://img.blog.csdn.net/20160802144058634)

### **总结** ###
这个小案例非常的简单，代码上也没有什么难点。用来实现底部导航栏还是一个不错的选择，这样的布局也是非常方便于平时练习敲demo，我之前写了一个基于MPCharts（一个开源的图表项目）的练习Demo也是用这样的布局。

最后给出这个案例的github地址吧。[NavigationBar](https://github.com/panyz/NavigationBar)