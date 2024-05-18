package com.yogesh.loader

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import kotlin.math.roundToInt

object MyLoader {
    public fun showLoader(
        parentLayout: ViewGroup,
        context: Context,
        lottieJsonAnim: Int?,
        sizeInDp: Int?
    ) {
        val myLoader = parentLayout.findViewById<LottieAnimationView>(R.id.myLoader)
        val overlay = parentLayout.findViewById<View>(R.id.overlay)

        if (myLoader == null && overlay == null) {
            val myLoaderNew = LottieAnimationView(context, null, 0)
            myLoaderNew.id = R.id.myLoader

            if (lottieJsonAnim != null) {
                myLoaderNew.setAnimation(lottieJsonAnim)
            } else {
                myLoaderNew.setAnimation(R.raw.loader)
            }
            val lottieLayoutParams: ConstraintLayout.LayoutParams = if (sizeInDp != null) {
                ConstraintLayout.LayoutParams(
                    dpToPx(context, sizeInDp),
                    dpToPx(context, sizeInDp)
                )
            } else {
                ConstraintLayout.LayoutParams(
                    dpToPx(context, 100),
                    dpToPx(context, 100)
                )
            }
            lottieLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            myLoaderNew.layoutParams = lottieLayoutParams
            myLoaderNew.playAnimation()
            myLoaderNew.repeatCount = LottieDrawable.INFINITE

            val overlayNew = View(context)
            overlayNew.id = R.id.overlay
            overlayNew.setBackgroundColor(context.getColor(R.color.bg_screen_for_loader))
            val overlayParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            parentLayout.addView(overlayNew, overlayParams)

            overlayNew.setOnClickListener { }

            parentLayout.addView(myLoaderNew, lottieLayoutParams)
        }
    }

    public fun showLoader(parentLayout: ViewGroup, context: Context) {
        val myLoader = parentLayout.findViewById<LottieAnimationView>(R.id.myLoader)
        val overlay = parentLayout.findViewById<View>(R.id.overlay)

        if (myLoader == null && overlay == null) {
            val myLoaderNew = LottieAnimationView(context, null, 0)
            myLoaderNew.id = R.id.myLoader

            myLoaderNew.setAnimation(R.raw.loader)

            val lottieLayoutParams: ConstraintLayout.LayoutParams =
                ConstraintLayout.LayoutParams(
                    dpToPx(context, 100),
                    dpToPx(context, 100)
                )

            lottieLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            myLoaderNew.layoutParams = lottieLayoutParams
            myLoaderNew.playAnimation()
            myLoaderNew.repeatCount = LottieDrawable.INFINITE

            val overlayNew = View(context)
            overlayNew.id = R.id.overlay
            overlayNew.setBackgroundColor(context.getColor(R.color.bg_screen_for_loader))
            val overlayParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            parentLayout.addView(overlayNew, overlayParams)

            overlayNew.setOnClickListener { }

            parentLayout.addView(myLoaderNew, lottieLayoutParams)
        }
    }

    public fun showLoader(parentLayout: ViewGroup, context: Context, lottieJsonAnim: Int?) {
        val myLoader = parentLayout.findViewById<LottieAnimationView>(R.id.myLoader)
        val overlay = parentLayout.findViewById<View>(R.id.overlay)

        if (myLoader == null && overlay == null) {
            val myLoaderNew = LottieAnimationView(context, null, 0)
            myLoaderNew.id = R.id.myLoader

            if (lottieJsonAnim != null) {
                myLoaderNew.setAnimation(lottieJsonAnim)
            } else {
                myLoaderNew.setAnimation(R.raw.loader)
            }
            val lottieLayoutParams: ConstraintLayout.LayoutParams =
                ConstraintLayout.LayoutParams(
                    dpToPx(context, 100),
                    dpToPx(context, 100)
                )

            lottieLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            myLoaderNew.layoutParams = lottieLayoutParams
            myLoaderNew.playAnimation()
            myLoaderNew.repeatCount = LottieDrawable.INFINITE

            val overlayNew = View(context)
            overlayNew.id = R.id.overlay
            overlayNew.setBackgroundColor(context.getColor(R.color.bg_screen_for_loader))
            val overlayParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            parentLayout.addView(overlayNew, overlayParams)

            overlayNew.setOnClickListener { }

            parentLayout.addView(myLoaderNew, lottieLayoutParams)
        }
    }

    public fun showLoader(parentLayout: ViewGroup, sizeInDp: Int?, context: Context) {
        val myLoader = parentLayout.findViewById<LottieAnimationView>(R.id.myLoader)
        val overlay = parentLayout.findViewById<View>(R.id.overlay)

        if (myLoader == null && overlay == null) {
            val myLoaderNew = LottieAnimationView(context, null, 0)
            myLoaderNew.id = R.id.myLoader

            myLoaderNew.setAnimation(R.raw.loader)

            val lottieLayoutParams: ConstraintLayout.LayoutParams = if (sizeInDp != null) {
                ConstraintLayout.LayoutParams(
                    dpToPx(context, sizeInDp),
                    dpToPx(context, sizeInDp)
                )
            } else {
                ConstraintLayout.LayoutParams(
                    dpToPx(context, 100),
                    dpToPx(context, 100)
                )
            }
            lottieLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
            lottieLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            myLoaderNew.layoutParams = lottieLayoutParams
            myLoaderNew.playAnimation()
            myLoaderNew.repeatCount = LottieDrawable.INFINITE

            val overlayNew = View(context)
            overlayNew.id = R.id.overlay
            overlayNew.setBackgroundColor(context.getColor(R.color.bg_screen_for_loader))
            val overlayParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            parentLayout.addView(overlayNew, overlayParams)

            overlayNew.setOnClickListener { }

            parentLayout.addView(myLoaderNew, lottieLayoutParams)
        }
    }

    public fun hideLoader(parentLayout: ViewGroup) {
        val myLoader = parentLayout.findViewById<LottieAnimationView>(R.id.myLoader)
        val overlay = parentLayout.findViewById<View>(R.id.overlay)

        overlay?.let {
            parentLayout.removeView(it)
            Log.d("YOsdfnlka", "overlay hide")
        }

        myLoader?.let {
            parentLayout.removeView(it)
            Log.d("YOsdfnlka", "loader hide")
        }
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }
}
