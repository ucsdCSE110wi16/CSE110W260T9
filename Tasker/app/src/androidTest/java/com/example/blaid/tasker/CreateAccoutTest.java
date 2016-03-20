package com.example.blaid.tasker;

/**
 * Created by zsp2014 on 3/12/16.
 */

import android.security.keystore.UserNotAuthenticatedException;
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



public class CreateAccoutTest {

    private String valUser1;
    private String valPassw1;
    private String email1;

    private String valUser2;
    private String valPassw2;
    private String email2;

    private String valUser3;
    private String valPassw3;
    private String email3;



    @Rule
    public ActivityTestRule<CreateAccount> createAccountActivityRule = new ActivityTestRule<>(CreateAccount.class);


    @Before
    public void initValidUser() {
        valUser1 = "zsp";
        valPassw1 = "sth";
        email1 = "a@a.com";

        valUser2 = "sombody";
        valPassw2 = "jozixucaf";
        email2 = "blahblah@gmail.com";

        valUser3 = "David";
        valPassw3 = "kxhcvigq";
        email3 = "something@gmail.com";

    }


    @Test
    public void changeText() {




        onView(withId(R.id.editTextUsername)).perform(typeText(valUser1), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(valPassw1), closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordConfirm)).perform(typeText(valPassw1), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(email1), closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());

        onView(withId(R.id.textView15)).check(matches(withText(R.string.Task_List)));

        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser1)));



        onView(withId(R.id.editTextUsername)).perform(typeText(valUser2), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(valPassw2), closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordConfirm)).perform(typeText(valPassw2), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(email2), closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());

        onView(withId(R.id.textView15)).check(matches(withText(R.string.Task_List)));

        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser2)));



        onView(withId(R.id.editTextUsername)).perform(typeText(valUser3), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(valPassw3), closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordConfirm)).perform(typeText(valPassw3), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(email3), closeSoftKeyboard());

        onView(withId(R.id.createButton)).perform(click());

        onView(withId(R.id.textView15)).check(matches(withText(R.string.Task_List)));

        onView(withId(R.id.textViewUsername)).check(matches(withText(valUser3)));

    }


}
