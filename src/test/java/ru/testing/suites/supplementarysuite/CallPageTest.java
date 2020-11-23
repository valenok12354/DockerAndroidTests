package ru.testing.suites.supplementarysuite;

import org.junit.jupiter.api.Test;
import ru.testing.suites.callsuite.AbstractCallTest;

public class CallPageTest extends AbstractCallTest {

    @Test
    public void holdCall() {
        autoHelpCall();
    }
}
