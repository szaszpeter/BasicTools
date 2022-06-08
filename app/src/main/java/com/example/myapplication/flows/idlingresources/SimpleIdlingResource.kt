package com.example.myapplication.flows.idlingresources

import android.util.Log
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.IdlingResource.ResourceCallback
import java.util.concurrent.atomic.AtomicBoolean


/**
 * This class is a sample for IdlingResource Usage.
 * Currently it is not used, but it is useful for Espresso Testing.
 * The one that is currently used is called SimpleIdlingResourceCompose, mostly the same concept as this one, but necessary for Compose Testing
 */
class SimpleIdlingResource(): IdlingResource {

    @Volatile
    private var mCallback: ResourceCallback? = null

    // Idleness is controlled with this boolean.
    var mIsIdleNow = AtomicBoolean(true);

    override fun getName(): String {
        return this.javaClass.name;
    }

    override fun registerIdleTransitionCallback(callback: ResourceCallback?) {
        mCallback = callback;
    }

    override fun isIdleNow(): Boolean {
        return mIsIdleNow.get();
    }

    /**
     * Sets the new idle state, if isIdleNow is true, it pings the [ResourceCallback].
     * @param isIdleNow false if there are pending operations, true if idle.
     */
    fun setIdleState(isIdleNow: Boolean) {
        mIsIdleNow.set(isIdleNow)
        Log.e("IDle", "State: $isIdleNow")
        if (isIdleNow && mCallback != null) {
            mCallback!!.onTransitionToIdle()
        }
    }

}