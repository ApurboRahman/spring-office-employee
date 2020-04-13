package sp.co.soe.emp.common.enums;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Screen {
    MASTER_REGISTRATION("SC_A1_01"),
    LEDGER_CREATION("SC_A1_02");


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
