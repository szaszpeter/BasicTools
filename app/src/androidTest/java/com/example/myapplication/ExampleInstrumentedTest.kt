package com.example.myapplication

import android.view.View
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.navigation.LauncherActivity
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.Description
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var mIdlingResourceCompose: androidx.compose.ui.test.IdlingResource? = null

    /**
     * Use [to launch and get access to the activity.][ActivityScenario.onActivity]
     */
    @Before
    fun registerIdlingResource() {
        val activityScenario: ActivityScenario<*> =
            ActivityScenario.launch(LauncherActivity::class.java)
        activityScenario.onActivity {
            mIdlingResourceCompose = (it as LauncherActivity).getIdlingResourceCompose()
            composeTestRule.registerIdlingResource(mIdlingResourceCompose!!)
        }
    }

    @get:Rule
    val composeTestRule = createEmptyComposeRule()

    @Test
    fun myTest() {
        composeTestRule.onNodeWithText("Launch Flow Sample").performClick()
        composeTestRule.onNodeWithText("Type some text").performTextInput("some text")
        composeTestRule.onNodeWithText("some text").assertIsDisplayed()
    }

    @After
    fun unregisterIdlingResource() {
        if (mIdlingResourceCompose != null) {
            composeTestRule.unregisterIdlingResource(mIdlingResourceCompose!!)
        }
    }
}

