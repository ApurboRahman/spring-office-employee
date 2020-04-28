package sp.co.soe.emp.common.enums;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Screen {
    MASTER_REGISTRATION("SC_A01_01"),
    LEDGER_CREATION("SC_A01_02"),
    MAIL_SEND_RESEND("SC_A03_01"),
    CARD_INVENTORY("SC_A04_01");


    private final String screenId;

    Screen(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenId() {
        return screenId;
    }

    public static Screen byName(String screenId) {
        return getSupplier().get().filter(
                screen -> screen.screenId.equals(screenId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Did not find Screen"));
    }

    private static Supplier<Stream<Screen>> getSupplier() {
        return () -> Stream.of(Screen.values());
    }
}
