# Android studio 实现文字的圆形背景

原文 https://blog.csdn.net/u012246458/article/details/51279957 

首先,在res->drawable下创建一个XML文件;

```XML
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
	<!--实心-->
    <solid android:color="@color/colorPrimary"/>
	<!--圆角-->
    <corners android:radius="360dp" />
	<!--边距-->
    <padding android:bottom="1dp"
        android:left="1dp"
        android:right="1dp"
        android:top="1dp"/>
    <!--大小-->
    <size android:height="100dp"
        android:width="100dp"/>
</shape>
```

在activity的引用如下

```XML
    <!--文字后面带圆形背景-->
        <TextView
        android:id="@+id/product_tag"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:singleLine="true"
        android:textSize="30dp"
        android:textColor="@color/colorAccent"
        android:layout_marginLeft="10dp"
                  
        android:background="@drawable/bg_yuan"
                  
        android:text="LOGO"
        android:layout_marginTop="48dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true" />
	<!--小圆点-->
    <TextView
              
        android:background="@drawable/yuandian"
              
        android:text=" "
        android:layout_width="25dp"
        android:layout_height="25dp"
        android:id="@+id/text_1"
        android:layout_alignBaseline="@+id/text_2"
        android:layout_alignBottom="@+id/text_2"
        android:layout_alignStart="@+id/product_tag" />
```

另一个XML文件

```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">

    <solid android:color="@color/colorPrimary" />
    <corners android:radius="360dp"/>

    <stroke
        android:width="1dp"
        android:color="@color/colorPrimary" />
</shape>
```

