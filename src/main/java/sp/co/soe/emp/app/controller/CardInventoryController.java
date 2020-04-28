package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.HttpResource;
import sp.co.soe.emp.app.form.CardInventoryForm;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.CardInventoryService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(Const.CARD_INVENTORY_URL)
public class CardInventoryController {
    private final CardInventoryService cardInventoryService;

    public CardInventoryController(CardInventoryService cardInventoryService) {
        this.cardInventoryService = cardInventoryService;
    }

    @GetMapping(Const.INIT_URL)
    public String index(Model model) {
        cardInventoryService.index(model, null, null);
        return Const.CARD_INVENTORY;
    }

    @GetMapping("search/{periodMonth}/{department}")
    public String searchCardInventory(@PathVariable String periodMonth, @PathVariable String department, Model model) {
        cardInventoryService.searchCardInventory(periodMonth, department, model);
        return Const.CARD_INVENTORY;
    }

    @PostMapping("save")
    public String save(@Valid CardInventoryForm cardInventoryForm, Model model, HttpServletResponse response) {
        cardInventoryService.save(cardInventoryForm, model, response);
        return Const.CARD_INVENTORY;
    }
}
