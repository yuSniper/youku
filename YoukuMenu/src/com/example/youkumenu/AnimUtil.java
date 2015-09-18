package com.example.youkumenu;

import android.R.anim;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimUtil {

	public static int animCount = 0;// 记录当前执行的动画数量

	// 关闭菜单
	public static void closeMenu(RelativeLayout rl, int startOffset) {
		// 遍历RelativeLayout布局中的子类
		for (int i = 0; i < rl.getChildCount(); i++) {
			// 将该布局设为不可点击
			rl.getChildAt(i).setEnabled(false);
		}
		// pivotXValue: 0-1
		// (float fromDegrees , float toDegrees)选择角度,
		// int pivotXType, float pivotXValue, 参照自己 0.5f X轴中心
		// int pivotYType, float pivotYValue 参照自己 1 Y轴
		RotateAnimation animation = new RotateAnimation(0, -180,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1);
		// 延时
		animation.setDuration(500);
		// 动画结束后保持当时的状态
		animation.setFillAfter(true);
		// 起始延迟时间
		animation.setStartOffset(startOffset);
		// 动画监听
		animation.setAnimationListener(new MyAnimationListener());
		// 开始执行动画
		rl.startAnimation(animation);
	}

	// 开启菜单
	public static void showMenu(RelativeLayout rl, int startOffset) {
		// 遍历RelativeLayout布局中的子类
		for (int i = 0; i < rl.getChildCount(); i++) {
			// 将该布局设为可点击
			rl.getChildAt(i).setEnabled(true);
		}
		// pivotXValue: 0-1
		// (float fromDegrees , float toDegrees)选择角度,
		// int pivotXType, float pivotXValue, 参照自己 0.5f X轴中心
		// int pivotYType, float pivotYValue 参照自己 1 Y轴
		RotateAnimation animation = new RotateAnimation(-180, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1);
		// 延时
		animation.setDuration(500);
		// 动画结束后保持当时的状态
		animation.setFillAfter(true);
		// 起始延迟时间
		animation.setStartOffset(startOffset);
		// 动画监听
		animation.setAnimationListener(new MyAnimationListener());
		// 开始执行动画
		rl.startAnimation(animation);
	}

	static class MyAnimationListener implements AnimationListener {
		// 动画开始
		@Override
		public void onAnimationStart(Animation animation) {
			animCount++;
		}

		// 动画结束
		@Override
		public void onAnimationEnd(Animation animation) {
			animCount--;
		}

		// 动画重复
		@Override
		public void onAnimationRepeat(Animation animation) {

		}

	}

}
