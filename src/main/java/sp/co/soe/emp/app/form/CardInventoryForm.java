package sp.co.soe.emp.app.form;

import lombok.Getter;
import lombok.Setter;
import sp.co.soe.emp.app.dto.CardInventoryDTO;

import java.util.List;

@Getter
@Setter
public class CardInventoryForm {
    private String periodMonth;
    private String department;
    private List<CardInventoryDTO> cardInventoryDtoList;
}
