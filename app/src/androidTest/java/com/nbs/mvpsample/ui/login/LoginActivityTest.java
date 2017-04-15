package com.nbs.mvpsample.ui.login;

import android.support.test.InstrumentationRegistry;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.TestComponentRule;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ghiyatshanif on 3/2/17.
 */

public class LoginActivityTest {
    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    @Before
    public void setup() {

    }

    @Test
    public void checkViewsDisplay() {
        onView(withId(R.id.edt_email))
                .check(matches(isDisplayed()));

        onView(withId(R.id.edt_password))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_login))
                .check(matches(isDisplayed()));

        onView(withText(R.string.login))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_google_login))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_fb_login))
                .check(matches(isDisplayed()));
    }

}
