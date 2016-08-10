package com.red.wolf.rxjavademo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.red.wolf.rxjavademo.utils.DebugUtils;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * 测试RxJava的Activity
 */
public class TestActivity extends AppCompatActivity {
    private String[] names = {"1", "2", "3", "4", "5", "6", "7"};

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_icon_test);
        //  将String数组中的依次打印
//        Observable.from(names).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                DebugUtils.LogI("onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                DebugUtils.LogI("Throwable" + e);
//            }
//
//            @Override
//            public void onNext(String name) {
//                DebugUtils.LogI(name);
//            }
//        });
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getTheme().getDrawable(R.drawable.xiana);
                subscriber.onNext(drawable);
                subscriber.onCompleted();

            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {
                DebugUtils.LogI("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                DebugUtils.LogI(e);

            }

            @Override
            public void onNext(Drawable drawable) {
                imageView.setImageDrawable(drawable);

            }
        });
    }
}
