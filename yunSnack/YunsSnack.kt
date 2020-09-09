package com.source.yunssnack.YunsSnack

import android.app.Activity
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.source.yunscustom.Animation.Fade
import com.source.yunscustom.R

class YunsSnack(activity: Activity) {
    var snackView: View? = null
    private var linf: LayoutInflater? = null
    private var insertPoint: ViewGroup? = null
    private var rlvHost: RelativeLayout? = null
    private var btnAction: Button? = null
    private var txtMessage: TextView? = null
    private var yunsSnackEventListener: YunsSnackEventListener? = null
    private var inAnim: Animation? = null
    private var outAnim: Animation? = null

    private fun initializeKSnackBar(parentView: View) {
        linf = parentView.context.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        insertPoint = parentView as ViewGroup

        // Create view.
        snackView = linf!!.inflate(R.layout.layout_yuns_snack, null)
        snackView!!.visibility = View.GONE
        ViewCompat.setTranslationZ(snackView!!, 999F)
        insertPoint!!.addView(
            snackView,
            1,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        // Initialize component view.
        rlvHost = snackView!!.findViewById(R.id.normal_snack_bar_rlv)

        // Initialize textview.
        txtMessage = snackView!!.findViewById(R.id.snack_bar_txt_message)

        // Action button.
        btnAction = snackView!!.findViewById(R.id.snack_bar_btn_action)

        // Set default in anim.
        inAnim = Fade.In.getAnimation()

        // Set default out anim.
        outAnim = Fade.Out.getAnimation()
    }

    // Get view.
    @JvmName("getSnackView1")
    fun getSnackView(): View? {
        return rlvHost
    }

    // Message.
    fun setMessage(@NonNull message: String?): YunsSnack {
        // Check null message.
        var message = message
        if (message == null) message = "n/a"
        txtMessage!!.text = message
        return this
    }

    // Duration
    fun setDuration(@NonNull millisecond: Int): YunsSnack {
        // Set duration.
        Handler().postDelayed({ dismiss() }, millisecond.toLong())
        return this
    }

    // Set button action.
    fun setAction(
        @NonNull buttonText: String?,
        @NonNull clickListener: View.OnClickListener?
    ): YunsSnack {
        // Change button visibility.
        btnAction!!.visibility = View.VISIBLE

        // Set button text.
        btnAction!!.text = buttonText

        // Set onClickListener.
        btnAction!!.setOnClickListener(clickListener)
        return this
    }

    // Background color (Color res).
    fun setBackColor(@NonNull @ColorRes colorInt: Int): YunsSnack {
        // Get current background drawable.
        val drawable = rlvHost!!.background

        // Change drawable background color.
        drawable.setColorFilter(rlvHost!!.context.resources.getColor(colorInt), PorterDuff.Mode.SRC)
        return this
    }

    // Background drawable (Drawable res).
    fun setBackgrounDrawable(@NonNull @DrawableRes drawableInt: Int): YunsSnack {
        // Set drawable to view.
        ViewCompat.setBackground(rlvHost!!, ContextCompat.getDrawable(rlvHost!!.context, drawableInt))
        return this
    }

    // Change description text color.
    fun setTextColor(@NonNull @ColorRes colorInt: Int): YunsSnack {
        // Change text color.
        txtMessage!!.setTextColor(txtMessage!!.context.resources.getColor(colorInt))
        return this
    }

    // Change button text color.
    fun setButtonTextColor(@NonNull @ColorRes colorInt: Int): YunsSnack {
        // Change button text color.
        btnAction!!.setTextColor(btnAction!!.context.resources.getColor(colorInt))
        return this
    }

    fun setTextTypeFace(@NonNull typeFace: Typeface?): YunsSnack {
        //Change text typeface.
        txtMessage!!.typeface = typeFace
        return this
    }

    fun setButtonTypeFace(@NonNull typeFace: Typeface?): YunsSnack {
        //Change text typeface.
        btnAction!!.typeface = typeFace
        return this
    }

    // Set Listener.
    fun setListener(listener: YunsSnackEventListener?): YunsSnack {
        yunsSnackEventListener = listener
        return this
    }

    // Set animation.
    fun setAnimation(inAnim: Animation?, outAnim: Animation?): YunsSnack {
        this.inAnim = inAnim
        this.outAnim = outAnim
        return this
    }

    fun show() {
        // Animation listener.
        inAnim!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                snackView!!.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                snackView!!.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        // Set animation to view.
        snackView!!.startAnimation(inAnim)

        // Start callback.
        yunsSnackEventListener?.showedSnackBar()
    }

    fun dismiss() {
        // Animation listener.
        outAnim!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                snackView!!.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                snackView!!.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        // Set animation to view.
        snackView!!.startAnimation(outAnim)

        // Stop callback.
        yunsSnackEventListener?.stoppedSnackBar()
    }

    fun dismissNow() {
        val animation: Animation = Fade.Out.getAnimation(200)
        // Animation listener.
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                snackView!!.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                snackView!!.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        // Set animation to view.
        snackView!!.startAnimation(animation)

        // Stop callback.
        yunsSnackEventListener?.stoppedSnackBar()
    }

    init {
        initializeKSnackBar(activity.findViewById(android.R.id.content))
    }
}

