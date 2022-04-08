package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseClasses.Base1;



public class Listener extends Base1 implements ITestListener 
{
public void onTestFailure(ITestResult result) 
{
	String TCName1 = result.getName();
	System.out.println("Failed TC name is "+result.getName());
	try {
	takeScreenShot(TCName1);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
public void onTestSuccess(ITestResult result) 
{
		System.out.println("Pass test case name is "+result.getName());
	}
}
