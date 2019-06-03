package com.lyz.myapplication.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lyz.myapplication.R;

public class FragmentFour extends Fragment {
    private ImageView image_four;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmentfour, container, false);
        initView(inflate);
        ObjectAnimator animator1=ObjectAnimator.ofFloat(image_four,"translationY",30,300);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(image_four,"scaleX",0.5f,3.5f);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(animator1).with(animator2);
        animatorSet.setDuration(5000);
        animatorSet.start();
        return inflate;
    }

    private void initView(View inflate) {
        image_four = (ImageView) inflate.findViewById(R.id.image_four);
    }
}
