package sp.co.soe.emp.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Slf4j
public class CSVParserUtil {

    public static boolean validateCSVFile(Model model, MultipartFile file){
        if(file.isEmpty()){
            log.warn(file.getOriginalFilename() + " file is empty");
            model.addAttribute("status", Messages.EMPTY_FILE);
            return false;
        }
        if(Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")){
            log.warn(file.getOriginalFilename() + " file is not CSV");
            model.addAttribute("message", file.getOriginalFilename());
            model.addAttribute("status", Messages.NOT_CSV);
            return false;
        }
        if(file.getSize()>Const.MAX_FILE_SIZE){
            log.warn(file.getOriginalFilename() + " file size exceeds 2MB");
            model.addAttribute("status", Messages.FILE_SIZE_EXCEED);
            return false;
        }
        return true;
    }
}
