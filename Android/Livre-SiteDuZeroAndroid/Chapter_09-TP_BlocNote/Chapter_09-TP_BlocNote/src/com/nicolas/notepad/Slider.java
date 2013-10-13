package com.nicolas.notepad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class Slider extends LinearLayout {

	// The menu which will be slided
	private RelativeLayout relativeLayoutToHide = null;
	private boolean isOpen = true;
	// Animation speed
	private static final int ANIMATION_SPEED = 300;
	
	Animation.AnimationListener openListener = new Animation.AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {
			relativeLayoutToHide.setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {}
		
		@Override
		public void onAnimationEnd(Animation animation) {}
	};
	
	Animation.AnimationListener closeListener = new Animation.AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation animation) {}
		
		@Override
		public void onAnimationRepeat(Animation animation) {}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			relativeLayoutToHide.setVisibility(View.GONE);
		}
	};
	
	/*public Slider(Context context) {
		super(context);
	}*/
	public Slider(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setRelativeLayoutToHide(RelativeLayout relativeLayoutToHide) {
		this.relativeLayoutToHide = relativeLayoutToHide;
	}
	
	public boolean toggle() {
		
		TranslateAnimation animation = null;
				
		if (isOpen) {
			// Animation from bottom to top
			animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -relativeLayoutToHide.getHeight());
			animation.setAnimationListener(closeListener);
		}
		else {
			// Animation from top to bottom
			animation = new TranslateAnimation(0.0f, 0.0f, -relativeLayoutToHide.getHeight(), 0.0f);
			animation.setAnimationListener(openListener);
		}
		
		animation.setDuration(ANIMATION_SPEED);
		animation.setInterpolator(new AccelerateInterpolator());
		startAnimation(animation);
		
		isOpen = !isOpen;
		return isOpen;
	}
}
