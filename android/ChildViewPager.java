package com.turboes.ht.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：mrwang
 * 时间：2017/9/15:17:52
 * 邮箱：2384359843@qq.com
 * 说明：
 */
public class ChildViewPager extends ViewPager {

    public ChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ChildViewPager(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /**
     * the last x position
     */
    private float lastX;

//    /**
//     * if the first swipe was from left to right (->), dont listen to swipes from the right
//     */
//    private boolean slidingLeft;
//
//    /**
//     * if the first swipe was from right to left (<-), dont listen to swipes from the left
//     */
//    private boolean slidingRight;


    //    不调用父类方法，直接return fase传给父view
    @Override
    public boolean onTouchEvent(final MotionEvent ev) {
        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                // Disallow parent ViewPager to intercept touch events.
//                this.getParent().requestDisallowInterceptTouchEvent(true);

                // save the current x position
                this.lastX = ev.getX();

                break;

            case MotionEvent.ACTION_UP:
                // Allow parent ViewPager to intercept touch events.
//                this.getParent().requestDisallowInterceptTouchEvent(false);

                // save the current x position
//                this.lastX = ev.getX();

                // reset swipe actions
//                this.slidingLeft = false;
//                this.slidingRight = false;

                break;

            case MotionEvent.ACTION_MOVE:
                /*
                 * if this is the first item, scrolling from left to
                 * right should navigate in the surrounding ViewPager
                 */
                if (this.getCurrentItem() == 0) {
                    // swiping from left to right (->)?
                    if (this.lastX <= ev.getX()
//                            && !this.slidingRight
                            ) {
                        // make the parent touch interception active -> parent pager can swipe
//                        this.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }

//                    else {
//                        /*
//                         * if the first swipe was from right to left, dont listen to swipes
//                         * from left to right. this fixes glitches where the user first swipes
//                         * right, then left and the scrolling state gets reset
//                         */
//                        this.slidingRight = true;
//
//                        // save the current x position
//                        this.lastX = ev.getX();
////                        this.getParent().requestDisallowInterceptTouchEvent(true);
//                    }
                } else if (this.getCurrentItem() == this.getAdapter().getCount() - 1) {
                /*
                 * if this is the last item, scrolling from right to
                 * left should navigate in the surrounding ViewPager
                 */

                    // swiping from right to left (<-)?
                    if (this.lastX >= ev.getX()
//                                && !this.slidingLeft
                            ) {
                        // make the parent touch interception active -> parent pager can swipe
//                            this.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }

//                        else {
//                        /*
//                         * if the first swipe was from left to right, dont listen to swipes
//                         * from right to left. this fixes glitches where the user first swipes
//                         * left, then right and the scrolling state gets reset
//                         */
//                            this.slidingLeft = true;
//
//                            // save the current x position
//                            this.lastX = ev.getX();
//                            this.getParent().requestDisallowInterceptTouchEvent(true);
//                        }
                }

                break;
        }

        super.onTouchEvent(ev);
        return true;
    }

}
