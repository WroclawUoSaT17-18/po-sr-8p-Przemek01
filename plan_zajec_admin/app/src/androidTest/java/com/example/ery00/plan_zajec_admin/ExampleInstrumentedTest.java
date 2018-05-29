package com.example.ery00.plan_zajec_admin;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;
import android.widget.Button;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);




    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.ery00.plan_zajec_admin", appContext.getPackageName());

    }



    @Test
    public void ZalogujTest() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        zaloguj Zaloguj;
        Zaloguj = new zaloguj(context,"usunrekord");
        Zaloguj.execute("","","","","","","");
    }

 MainActivity mainActivity;
    @Before
    public void SetUp() throws Exception {mainActivity = mainActivityActivityTestRule.getActivity();}

    @Test
    public void buttonTest() throws Exception {
        // Context of the app under test.
        View view = mainActivity.findViewById(R.id.button2);
        assertNotNull(view);

      boolean buton =  mainActivity.Onlogin(view);
      assertEquals(true,buton);


    }



}
