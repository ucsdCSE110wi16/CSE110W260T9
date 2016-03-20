package com.example.blaid.tasker;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by zsp2014 on 3/11/16.
 */
public class LoginTest {

    private String valUser;
    private String valPassw;


    @Rule
    public ActivityTestRule<Login> loginActivityRule = new ActivityTestRule<>(Login.class);


    @Before
    public void initValidUser() {
        // Specify a valid username "a@a.com" and password "a"
        valUser = "admin";
        valPassw = "admin";
    }


    @Test
    public void changeTextInMainPage() {



        // Type in a valid user name "a@a.com" and its valid password "a"
        onView(withId(R.id.username)).perform(typeText(valUser), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(valPassw), closeSoftKeyboard());

        // Click the Sign In button
        onView(withId(R.id.clicktosignin)).perform(click());

        // Check that the greetings in the MainActivity has the user's name ("Antelope")

        onView(withId(R.id.textView15)).check(matches(withText(R.string.Task_List)));
    }

}
