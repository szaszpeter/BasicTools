package com.example.myapplication.flows.idlingresources

import android.util.Log
import androidx.compose.ui.test.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean

/**
 * This class is a usage sample for Idling Resources in a Compose Testing context.
 */
class SimpleIdlingResourceCompose(): IdlingResource {

    @Volatile
    private var mCallback: androidx.test.espresso.IdlingResource.ResourceCallback? = null

    // Idleness is controlled with this boolean.
    var mIsIdleNow = AtomicBoolean(true);

    /**
     * Update the idle state.
     */
    fun setIdleState(isIdleNow: Boolean) {
        mIsIdleNow.set(isIdleNow)
        Log.e("IDle", "State: $isIdleNow")
    }

    override val isIdleNow: Boolean
        get() {
            return mIsIdleNow.get()
        }

}