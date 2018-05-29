package com.example.ery00.plan_zajec_klient;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by ery00 on 2018-05-29.
 */
public class MainActivityTest {

    @Rule
   public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;
Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PobierzActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }



    @Test
    public void onPobierz() throws Exception {
        assertNotNull(mainActivity.findViewById(R.id.button));

        onView(withId(R.id.button)).perform(click());

        Activity PobierzActivity =getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(PobierzActivity);

        PobierzActivity.finish();
    }




    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }





}