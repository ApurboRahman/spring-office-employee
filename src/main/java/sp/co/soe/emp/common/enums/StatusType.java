package sp.co.soe.emp.common.enums;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum StatusType {
    REGISTERED_TO_MASTER(1),
    LEDGER_CREATED(2),
    REQUESTED_INVENTORY(3),
    SENT_REMIND(4),
    MONTHLY_CLOSING_DONE(5),
    RELEASE_CLOSING(6);

    private final int value;

    StatusType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusType forValue(int value) {
        return statusSupplier().get().filter(statusType -> statusType.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(StatusType.class.getName()));
    }

    public static Supplier<Stream<StatusType>> statusSupplier() {
        return () -> Stream.of(StatusType.values());
    }
}
