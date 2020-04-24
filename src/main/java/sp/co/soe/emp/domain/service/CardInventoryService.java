package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

@Service
public interface CardInventoryService {
    void index(Model model);
    List<Date> getPeriodMonth();
}
