package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.CardsChkBean;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.app.dtoToBean.CardInventoryDtoToBean;
import sp.co.soe.emp.app.form.CardInventoryForm;
import sp.co.soe.emp.app.dto.CardInventoryDTO;
import sp.co.soe.emp.app.helper.UserInfoHelper;
import sp.co.soe.emp.common.enums.Screen;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.DateUtil;
import sp.co.soe.emp.domain.entity.CardsChkExample;
import sp.co.soe.emp.domain.entity.Departments;
import sp.co.soe.emp.domain.entity.UsersAccount;
import sp.co.soe.emp.domain.repository.CardInventoryMapper;
import sp.co.soe.emp.domain.repository.CardsChkMapper;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.jpaRepository.CardsChkRepository;
import sp.co.soe.emp.domain.service.CardInformationService;
import sp.co.soe.emp.domain.service.CardInventoryService;
import sp.co.soe.emp.domain.service.DepartmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardInventoryServiceImpl implements CardInventoryService {
    private final CardsChkMapper cardsChkMapper;
    private final CardsChkExample cardsChkExample;
    private final DepartmentService departmentService;
    private final CardsChkRepository cardsChkRepository;
    private final DateMapper dateMapper;
    private final CardInventoryMapper cardInventoryMapper;
    private final EmployeeMasterServiceImpl employeeMasterService;
    private final CardInventoryDtoToBean cardInventoryDtoToBean;
    private final CardInformationService cardInformationService;

    public CardInventoryServiceImpl(CardsChkMapper cardsChkMapper,
                                    CardsChkExample cardsChkExample,
                                    DepartmentService departmentService,
                                    CardsChkRepository cardsChkRepository,
                                    DateMapper dateMapper,
                                    CardInventoryMapper cardInventoryMapper,
                                    EmployeeMasterServiceImpl employeeMasterService,
                                    CardInventoryDtoToBean cardInventoryDtoToBean,
                                    CardInformationService cardInformationService) {
        this.cardsChkMapper = cardsChkMapper;
        this.cardsChkExample = cardsChkExample;
        this.departmentService = departmentService;
        this.cardsChkRepository = cardsChkRepository;
        this.dateMapper = dateMapper;
        this.cardInventoryMapper = cardInventoryMapper;
        this.employeeMasterService = employeeMasterService;
        this.cardInventoryDtoToBean = cardInventoryDtoToBean;
        this.cardInformationService = cardInformationService;
    }

    @Override
    public void index(Model model, Date periodMonth, String department) {
        CardInventoryForm cardInventoryForm = new CardInventoryForm();

        List<String> periodMonths = cardsChkMapper.getPeriodMonth();

        List<Departments> departmentList = getDepartmentList();
        if (null == periodMonth) {
            periodMonth = dateMapper.selectFirstDayOfMonth();
        }
        if (Const.NULL_STRING == department) {
            department = getLoginUserInfo().getDeptCode();
        }

        List<CardInventoryDTO> cardInfoList = cardInventoryMapper.getCardInventory(periodMonth, department);
        cardInfoList.stream().map(card->DateUtil.strToDt(card.getPeriodMonth().toString(),"yyyy-MM-dd")).collect(Collectors.toList());
        cardInventoryForm.setPeriodMonth(DateUtil.dtToStr(getCurrentPeriodMonth()));
        cardInventoryForm.setDepartment(department);
        cardInventoryForm.setCardInventoryDtoList(cardInfoList);
        model.addAttribute("periodMonths", periodMonths);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("currentDate", DateUtil.dtToStr(periodMonth));
        model.addAttribute(cardInventoryForm);
    }

    @Override
    public List<Date> getPeriodMonth() {
        return cardsChkMapper.selectDistinctPeriodMonth();
    }

    @Override
    public void searchCardInventory(String periodMonth, String department, Model model) {
        Date currentDate = DateUtil.strToDt(periodMonth, "yyyy-MM-dd");
        index(model, currentDate, department);
    }

    @Override
    public void save(CardInventoryForm cardInventoryForm, Model model, HttpServletResponse response) {
        List<CardInventoryDTO> cardInventoryList = cardInventoryForm.getCardInventoryDtoList();
        for(CardInventoryDTO dto:cardInventoryList){
            dto.setChkUserId(getLoginUserInfo().getEmployeeId());
            dto.setChkDate(getCurrentPeriodMonth());
            dto.setChkFlg(Const.checkedFlag.toString());
            CardInformationBean cardRetainBean = cardInventoryDtoToBean.cardDtoToCardRetainBean(dto);
            CardsChkBean cardsChkBean = cardInventoryDtoToBean.cardDtoToCardChkBean(dto);
            cardInformationService.updateCardRetainInfo(cardRetainBean, Screen.CARD_INVENTORY.getScreenId());
            cardInformationService.updateCardChkInfo(cardsChkBean, Screen.CARD_INVENTORY.getScreenId());

        }

        index(model, DateUtil.strToDt(cardInventoryForm.getPeriodMonth(), "yyyy-MM-dd"), cardInventoryForm.getDepartment());
    }

    private List<Departments> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

    private Date getCurrentPeriodMonth() {
        return dateMapper.selectFirstDayOfMonth();
    }

    private EmployeeInformationBean getLoginUserInfo() {
        UsersAccount account = UserInfoHelper.getLoginUserInfo();
        return employeeMasterService.getEmployeeDetails(account.getUserName());
    }
}
