package com.example.myapplication.navigation

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.flows.idlingresources.SimpleIdlingResourceCompose
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {


    // The Idling Resource which will be null in production.
    @Nullable
    var mIdlingResourceCompose: SimpleIdlingResourceCompose? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher_host)
    }

    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    @VisibleForTesting
    @NonNull
    fun getIdlingResourceCompose(): androidx.compose.ui.test.IdlingResource? {
        if (mIdlingResourceCompose == null) {
            mIdlingResourceCompose = SimpleIdlingResourceCompose()
        }
        return mIdlingResourceCompose
    }

}