package sp.co.soe.emp.common.enums;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum Role {
    EMPLOYEE(1),
    HUMAN_RESOURCES(2),
    IT_INFRASTRUCTURE(3),
    BUSINESS_PLANNER(4),
    SECTION_MANAGER_AND_ABOVE(5),
    SECURITY_COMMITTEE(6);

    private final int value;
    Role(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    /**
     * Returns Role for given value
     *
     * @param value value of Role
     * @return Role representing given value;
     */
    public static Role forValue(int value) {
        return roleSupplier().get().filter(role -> role.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Role.class.getName()));
    }

    private static Supplier<Stream<Role>> roleSupplier() {
        return () -> Stream.of(Role.values());
    }
}
