package ru.testing;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import ru.testing.suites.callsuite.GSMCallTest;
import ru.testing.suites.callsuite.WCDMACallTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({GSMCallTest.class, WCDMACallTest.class})
public class CallSuite {
}
