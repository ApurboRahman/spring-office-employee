package sp.co.soe.emp.common.enums;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum MenuType {
    MASTER_REGISTRATION(1),
    LEDGER_CREATION(2),
    INVENTORY_REQUEST_REMIND_SEND(3),
    MONTHLY_CLOSING(4),
    BATCH_SCHEDULE(5),
    USER_PERMISSION_SETTINGS(6),
    INVENTORY_STATUS_CONFIRMATION(7),
    SECURITY_CARD_INVENTORY(8),
    VPN_DONGLE_INVENTORY(9),
    INVENTORY(10),
    ADMINISTRATION(11);


    private final Integer menuId;

    MenuType(Integer menuId) {
        this.menuId = menuId;

    }

    public Integer getMenuId() {
        return menuId;
    }

    /**
     *
     * @param menuId
     * @return
     */
    public static MenuType byValue(Integer menuId) {
        return menusSupplier().get().filter(menuType -> menuType.menuId.equals(menuId)).findFirst().orElseThrow(()->
        new IllegalArgumentException("Menu cannot create " + menuId));
    }

    private static Supplier<Stream<MenuType>> menusSupplier() {
        return () -> Stream.of(MenuType.values());
    }
}
