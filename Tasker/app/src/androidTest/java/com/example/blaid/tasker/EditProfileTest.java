package com.example.blaid.tasker;

/**
 * Created by zsp2014 on 3/12/16.
 */


import android.support.test.espresso.Espresso;
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


public class EditProfileTest {


    private String valUser1;
    private String selfDescription1;

    private String valUser2;
    private String selfDescription2;

    private String valUser3;
    private String selfDescription3;


    @Rule
    public ActivityTestRule<EditProfile> editProfileActivityTestRule = new ActivityTestRule<>(EditProfile.class);


    @Before
    public void initValidUser() {
        valUser1 = "new_username";
        selfDescription1 = "This is a new self-description";

        valUser2 = "new_username";
        selfDescription2 = "This is a new self-description";

        valUser3 = "new_username";
        selfDescription3 = "This is a new self-description";

    }


    @Test
    public void changeText() {



        onView(withId(R.id.editText)).perform(typeText(valUser1), closeSoftKeyboard());
        onView(withId(R.id.editText5)).perform(typeText(selfDescription1), closeSoftKeyboard());

        onView(withId(R.id.startID)).perform(click());

        onView(withId(R.id.textView6)).check(matches(withText(selfDescription1)));
        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser1)));

        onView(withId(R.id.editText)).perform(typeText(valUser2), closeSoftKeyboard());
        onView(withId(R.id.editText5)).perform(typeText(selfDescription2), closeSoftKeyboard());

        onView(withId(R.id.startID)).perform(click());

        onView(withId(R.id.textView6)).check(matches(withText(selfDescription2)));
        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser2)));

        onView(withId(R.id.editText)).perform(typeText(valUser3), closeSoftKeyboard());
        onView(withId(R.id.editText5)).perform(typeText(selfDescription3), closeSoftKeyboard());

        onView(withId(R.id.startID)).perform(click());

        onView(withId(R.id.textView6)).check(matches(withText(selfDescription3)));
        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser3)));



    }



}
