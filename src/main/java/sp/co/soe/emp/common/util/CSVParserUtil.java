package sp.co.soe.emp.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
public class CSVParserUtil {

    public static boolean validateCSVFile(Model model, MultipartFile file) {
        if (file.isEmpty()) {
            log.warn(file.getOriginalFilename() + " file is empty");
            model.addAttribute("status", Messages.EMPTY_FILE);
            return false;
        }
        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".csv")) {
            log.warn(file.getOriginalFilename() + " file is not CSV");
            model.addAttribute("message", file.getOriginalFilename());
            model.addAttribute("status", Messages.NOT_CSV);
            return false;
        }
        if (file.getSize() > Const.MAX_FILE_SIZE) {
            log.warn(file.getOriginalFilename() + " file size exceeds 2MB");
            model.addAttribute("status", Messages.FILE_SIZE_EXCEED);
            return false;
        }
        return true;
    }

    /**
     * save csv file in the given file location
     *
     * @param model
     * @param file
     * @param directoryPath
     * @param newFileName
     * @return true if file is saved in the file location false otherwise
     */
    public static boolean saveCSVFileInGivenPatch(Model model, MultipartFile file, String directoryPath, String newFileName) {
        if (!createDirectory(directoryPath) || !createBackupDirectory(directoryPath)) {
            log.warn("could not create directory.");
            model.addAttribute("error", Messages.DIRECTORY_ERROR);
            return false;
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(directoryPath + newFileName);
            Files.write(path, bytes);
            log.info("File writing completed");
        } catch (IOException e) {
            e.printStackTrace();
            log.warn(newFileName + " could not be uploaded");
            model.addAttribute("error", Messages.UPLOAD_ERROR);
            return false;
        }
        return true;
    }

    public static boolean createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            log.info("create folder in " + directoryPath);
            return directory.mkdir();
        }
        return true;
    }

    public static boolean createBackupDirectory(String directoryPath) {
        String backupFolder = directoryPath + File.separator + Const.BACKUP_FOLDER_NAME;
        return createDirectory(backupFolder);
    }
}
