package com.seleniumframework;

import com.seleniumframework.Models.Browser;
import com.seleniumframework.Models.TestCase;
import com.seleniumframework.Models.TestSet;
// import com.seleniumframework.TestCases.LoginSauceDemoPage.LoginToSauceDemoPage;
// import com.seleniumframework.TestCases.TC_01.SearchThirdProduct;
// import com.seleniumframework.TestCases.TC_02.CheckOutExpensiveProduct;
// import com.seleniumframework.TestCases.TC_03.TestFindElement;
import com.seleniumframework.TestCases.TC_Demo.BookingRoomDelta;

public class Main {
    public static void main(String[] args) {
        //Login
        // TestCase tc1 = new LoginToSauceDemoPage(Browser.Chrome);
        // TestCase tc2 = new LoginToSauceDemoPage(Browser.Edge);

        //TC_01 Select third product.
        // TestCase tc1 = new SearchThirdProduct(Browser.Chrome);

        //TC_02
        TestCase tc1 = new BookingRoomDelta(Browser.Chrome);

        //TC_03
        // TestCase tc1 = new TestFindElement(Browser.Chrome);
        try {
          new TestSet(tc1).run();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}