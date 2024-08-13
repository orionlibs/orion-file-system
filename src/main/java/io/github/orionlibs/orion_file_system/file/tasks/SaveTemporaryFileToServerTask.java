package io.github.orionlibs.orion_file_system.file.tasks;

import io.github.orionlibs.orion_file_system.file.FileService;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class SaveTemporaryFileToServerTask
{
    public static File run(MultipartFile file, String fileNamePrefix, String tempFolder)
    {
        if(file != null)
        {
            File tempFile = null;
            try
            {
                String fileExtension = FileService.getFileExtension(file.getOriginalFilename());
                String tempFileName = tempFolder;
                if(fileNamePrefix != null && !fileNamePrefix.isEmpty())
                {
                    tempFileName += fileNamePrefix + "-";
                }
                tempFileName += UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;
                tempFile = new File(tempFileName);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }
        }
        return null;
    }


    public static File run(String fileNameToUse, String tempFolder, MultipartFile file)
    {
        if(file != null)
        {
            File tempFile = null;
            try
            {
                tempFile = new File(tempFolder + fileNameToUse);
                FileService.saveFile(file, tempFile);
                return tempFile;
            }
            catch(IOException e)
            {
                return null;
            }
        }
        return null;
    }
}