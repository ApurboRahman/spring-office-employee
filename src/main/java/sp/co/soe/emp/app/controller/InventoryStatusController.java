package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;

@Controller
@RequestMapping(Const.INVENTORY_STATUS_URL)
public class InventoryStatusController {

    @GetMapping(Const.INIT_URL)
    public String index(Model model){
        return Const.INVENTORY_STATUS;
    }
}
