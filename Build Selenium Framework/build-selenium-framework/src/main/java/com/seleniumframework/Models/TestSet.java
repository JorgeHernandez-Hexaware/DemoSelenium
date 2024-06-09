package com.seleniumframework.Models;

import com.seleniumframework.Execution.Execution;

public class TestSet {
    private TestCase[] testCases;

    public TestSet(TestCase... _testCases) throws Exception{
        if (_testCases.length==0) throw new Exception("There are not any test cases specified");
        this.testCases = _testCases;
    }

    public void run() throws Exception{
        if(this.testCases == null) throw new Exception("Test Case Null");
        new Execution(this.testCases);
    }
}
