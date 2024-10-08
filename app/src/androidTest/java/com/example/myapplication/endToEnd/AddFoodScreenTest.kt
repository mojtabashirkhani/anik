package com.example.myapplication.endToEnd

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.myapplication.MainActivity
import com.example.myapplication.screen.addFood.AddFoodScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AddFoodScreenTest {

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Before
    fun setup() {
        // Inject Hilt dependencies before tests run
        hiltRule.inject()

        composeTestRule.setContent {
            AddFoodScreen()
        }

    }

    @Test
    fun testAddFood() {

        // Enter food name
        composeTestRule.onNodeWithText("Food Name").performTextInput("Pizza")

        // Click on Add Food button
        composeTestRule.onNodeWithText("Add Food").performClick()

    }
}