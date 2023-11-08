package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.textfield.TextInputEditText
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Task020Test {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_input() {
        onView(
            allOf(
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout)),
                isAssignableFrom(TextInputEditText::class.java),
                withId(R.id.inputEditText)
            )
        ).check(matches(withText("")))

        onView(
            allOf(
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout)),
                isAssignableFrom(Button::class.java),
                withId(R.id.actionButton),
                withText("change")
            )
        ).check(matches(isEnabled()))

        onView(
            allOf(
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(R.id.rootLayout)),
                isAssignableFrom(TextView::class.java),
                withId(R.id.titleTextView),
                withText("Hello World!")
            )
        ).check(matches(isDisplayed()))

        onView(withId(R.id.inputEditText)).perform(typeText("A new text now!"), closeSoftKeyboard())
        onView(withId(R.id.actionButton)).perform(click())
        onView(withId(R.id.inputEditText)).check(matches(withText("")))
        onView(withId(R.id.titleTextView)).check(matches(withText("A new text now!")))

        activityScenarioRule.scenario.recreate()
        onView(withId(R.id.inputEditText)).check(matches(withText("")))
        onView(withId(R.id.titleTextView)).check(matches(withText("A new text now!")))
    }
}