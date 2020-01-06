# TextView 跑马灯

布局文件里

```XMl
    <TextView
        android:ellipsize="marquee"
        android:focusable="true"
        android:focusableInTouchMode="true"
        android:marqueeRepeatLimit="marquee_forever"
        android:singleLine="true"

        android:text="TextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_x="159dp"
        android:layout_y="489dp"
        android:id="@+id/zanZhuShang" />
```

Activity里

```java
TextView textView = (TextView) findViewById(R.id.zanZhuShang);
                        textView.setText(str.toString());
                        //让跑马灯跑起来
                        textView.setSelected(true);
```

