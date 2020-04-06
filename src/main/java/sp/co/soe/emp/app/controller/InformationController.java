package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.InformationService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Const.INFORMATION_URL)
public class InformationController {
    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("")
    public String index(Model model, HttpSession session){
        informationService.getInformationDetails(model,session);
        return Const.INFORMATION;
    }
}
