package com.source.yunsnack.Animation

import android.view.View
import android.view.animation.*
import android.widget.LinearLayout

object Slide {
    private const val DEFAULT_ANIM_TIME: Long = 400
    private var animation: Animation? = null
    fun isMinimalKSnack(view: View): Boolean {
        return view.resources.getResourceEntryName(view.id) == "minimal_snack_bar_rlv"
    }

    object Up {
        // Slide up anim without optional anim time and interpolator.
        fun getAnimation(view: View): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f, .0f,
                    (-view.measuredHeight).toFloat()
                )
            } else {
                animation = TranslateAnimation(
                    .0f, .0f,
                    view.measuredHeight.toFloat(), 0f
                )
            }
            (animation as TranslateAnimation).duration = DEFAULT_ANIM_TIME
            (animation as TranslateAnimation).interpolator = AccelerateInterpolator()
            return animation
        }

        // Slide up anim with optional anim time.
        fun getAnimation(view: View, millisecond: Int): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f, .0f,
                    (-view.measuredHeight).toFloat()
                )
            } else {
                animation = TranslateAnimation(
                    .0f, .0f,
                    view.measuredHeight.toFloat(), 0f
                )
            }
            (animation as TranslateAnimation).duration = millisecond.toLong()
            (animation as TranslateAnimation).interpolator = AccelerateInterpolator()
            return animation
        }

        // Slide up anim with optional anim time and interpolator.
        fun getAnimation(view: View, millisecond: Int, interpolator: Interpolator?): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f, .0f,
                    (-view.measuredHeight).toFloat()
                )
            } else {
                animation = TranslateAnimation(
                    .0f, .0f,
                    view.measuredHeight.toFloat(), 0f)
            }
            (animation as TranslateAnimation).duration = millisecond.toLong()
            (animation as TranslateAnimation).interpolator = interpolator
            return animation
        }
    }

    object Down {
        // Slide down anim without optional anim time and interpolator.
        fun getAnimation(view: View): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f,
                    (-view.measuredHeight).toFloat(), .0f
                )
            } else {
                animation = TranslateAnimation(
                    0f, 0f, .0f,
                    view.measuredHeight.toFloat()
                )
            }
            (animation as TranslateAnimation).duration = DEFAULT_ANIM_TIME
            (animation as TranslateAnimation).interpolator = DecelerateInterpolator()
            return animation
        }

        // Slide down anim with optional anim time.
        fun getAnimation(view: View, millisecond: Int): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f,
                    (-view.measuredHeight).toFloat(), .0f
                )
            } else {
                animation = TranslateAnimation(
                    0f, 0f, .0f,
                    view.measuredHeight.toFloat()
                )
            }
            (animation as TranslateAnimation).duration = millisecond.toLong()
            (animation as TranslateAnimation).interpolator = DecelerateInterpolator()
            return animation
        }

        // Slide down anim with optional anim time and interpolator.
        fun getAnimation(view: View, millisecond: Int, interpolator: Interpolator?): Animation? {
            view.measure(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            if (isMinimalKSnack(view)) {
                animation = TranslateAnimation(
                    .0f, .0f,
                    (-view.measuredHeight).toFloat(), .0f
                )
            } else {
                animation = TranslateAnimation(
                    0f, 0f, .0f,
                    view.measuredHeight.toFloat()
                )
            }
            (animation as TranslateAnimation).duration = millisecond.toLong()
            (animation as TranslateAnimation).interpolator = interpolator
            return animation
        }
    }
}