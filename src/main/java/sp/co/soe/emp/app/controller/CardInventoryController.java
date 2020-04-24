package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.CardInventoryService;

@Controller
@RequestMapping(Const.CARD_INVENTORY_URL)
public class CardInventoryController {
    private final CardInventoryService cardInventoryService;

    public CardInventoryController(CardInventoryService cardInventoryService) {
        this.cardInventoryService = cardInventoryService;
    }

    @GetMapping(Const.INIT_URL)
    public String index(Model model){
        cardInventoryService.index(model);
        return Const.CARD_INVENTORY;
    }
}
