package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.domain.entity.CardsChkExample;
import sp.co.soe.emp.domain.repository.CardsChkMapper;
import sp.co.soe.emp.domain.repository.jpaRepository.CardsChkRepository;
import sp.co.soe.emp.domain.service.CardInventoryService;
import sp.co.soe.emp.domain.service.DepartmentService;

import java.util.Date;
import java.util.List;

@Service
public class CardInventoryServiceImpl implements CardInventoryService {
    private final CardsChkMapper cardsChkMapper;
    private final CardsChkExample cardsChkExample;
    private final DepartmentService departmentService;
    private final CardsChkRepository cardsChkRepository;

    public CardInventoryServiceImpl(CardsChkMapper cardsChkMapper,
                                    CardsChkExample cardsChkExample,
                                    DepartmentService departmentService,
                                    CardsChkRepository cardsChkRepository) {
        this.cardsChkMapper = cardsChkMapper;
        this.cardsChkExample = cardsChkExample;
        this.departmentService = departmentService;
        this.cardsChkRepository = cardsChkRepository;
    }

    @Override
    public void index(Model model) {
        List<Date> periodMonth = getPeriodMonth();
      //  List<Date> periodMonths = cardsChkRepository.selectDistinctPeriodMonth();
        List<Date> periodMonths = cardsChkMapper.selectPeriodMonth();
        List departmentList = getDepartmentList();
        model.addAttribute("periodMonth", periodMonth);
        model.addAttribute("periodMonths", periodMonths);
        model.addAttribute("departmentList", departmentList);
    }

    @Override
    public List<Date> getPeriodMonth() {
        return cardsChkMapper.selectDistinctPeriodMonth();
    }

    private List getDepartmentList() {
        return departmentService.getDepartmentList();
    }
}
