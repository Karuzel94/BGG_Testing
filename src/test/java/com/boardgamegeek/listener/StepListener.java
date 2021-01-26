package com.boardgamegeek.listener;


import com.boardgamegeek.utilities.Log;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class StepListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        Log.logInfo("abc");
    }



}
