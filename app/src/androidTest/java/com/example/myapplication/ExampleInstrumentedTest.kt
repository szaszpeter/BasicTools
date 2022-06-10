package com.example.myapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.navigation.LauncherActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var mIdlingResourceCompose: IdlingResource? = null

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

        // First assertion checks if there are in total 2 view with the same text. Normally the processed output is uppercase
        // but in order to count the views, we are ignoring the case at this point.
        composeTestRule.onAllNodes(hasText("some text", false ,ignoreCase = true)).assertCountEquals(2)

        // Second assertion that checks that indeed the processed text is displayed with Caps. This is also a good example for
        // semantics matchers.
        composeTestRule.onNodeWithText("SOME TEXT").assert(hasText("SOME TEXT",
            substring = false,
            ignoreCase = false
        ))

    }

    @After
    fun unregisterIdlingResource() {
        if (mIdlingResourceCompose != null) {
            composeTestRule.unregisterIdlingResource(mIdlingResourceCompose!!)
        }
    }
}

