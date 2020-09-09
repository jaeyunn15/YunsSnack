package com.source.yunsnack.Animation

import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Interpolator

object Fade {
    private const val DEFAULT_ANIM_TIME: Long = 300
    private var animation: Animation? = null

    object In {
        // Fade out anim without optional anim time and interpolator.
        fun getAnimation(): Animation {
            animation = AlphaAnimation(0f, 1f)
            animation!!.duration = DEFAULT_ANIM_TIME
            animation!!.interpolator = AccelerateInterpolator()
            return animation!!
        }

        // Fade out anim with optional anim time.
        fun getAnimation(millisecond: Long): Animation {
            animation = AlphaAnimation(0f, 1f)
            animation!!.duration = millisecond
            animation!!.interpolator = AccelerateInterpolator()
            return animation!!
        }

        // Fade out anim with optional anim time and interpolator.
        fun getAnimation(millisecond: Long, interpolator: Interpolator?): Animation {
            animation = AlphaAnimation(0f, 1f)
            animation!!.duration = millisecond
            animation!!.interpolator = interpolator
            return animation!!
        }
    }

    object Out {
        // Fade out anim without optional anim time and interpolator.
        fun getAnimation(): Animation {
            animation = AlphaAnimation(1f, 0f)
            animation!!.duration = DEFAULT_ANIM_TIME
            animation!!.interpolator = AccelerateInterpolator()
            return animation!!
        }

        // Fade out anim with optional anim time.
        fun getAnimation(millisecond: Int): Animation {
            animation = AlphaAnimation(1f, 0f)
            animation!!.duration = millisecond.toLong()
            animation!!.interpolator = AccelerateInterpolator()
            return animation!!
        }

        // Fade out anim with optional anim time and interpolator.
        fun getAnimation(millisecond: Int, interpolator: Interpolator?): Animation {
            animation = AlphaAnimation(1f, 0f)
            animation!!.duration = millisecond.toLong()
            animation!!.interpolator = interpolator
            return animation!!
        }
    }
}