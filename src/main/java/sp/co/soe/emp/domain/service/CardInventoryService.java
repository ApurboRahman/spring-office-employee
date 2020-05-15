package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.form.CardInventoryForm;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public interface CardInventoryService {

    void index(Model model, Date periodMonth, String department);

    List<Date> getPeriodMonth();

    void searchCardInventory(String periodMonth, String department, Model model);

    void save(CardInventoryForm cardInventoryForm, Model model, HttpServletResponse response);

    void approve(CardInventoryForm cardInventoryForm, Model model, HttpServletResponse response);
}
