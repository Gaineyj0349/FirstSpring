package com.gainey.exceltojson.Spring;

import com.gainey.exceltojson.Objects.WorkBookExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class ExtractorController {


    @PostMapping("/extract")
    public String jsonString(@RequestParam(name="fileupload")
                                     MultipartFile file, Model model){
        if(!file.getOriginalFilename().endsWith("xlsx")){
            model.addAttribute("JSONresult", "Not a valid file format. "+
                    file.getOriginalFilename());
            return "displayJSON";
        }
        try {

            //create a temp File object
            byte[] bytes = file.getBytes();


            File tempFile = File.createTempFile("TEMP","file.getOriginalFilename()",null);
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(bytes);


            FileInputStream fs = new FileInputStream(tempFile);
            Workbook workbook = new XSSFWorkbook(fs);
            WorkBookExtractor workBookExtractor = new WorkBookExtractor(workbook);
            String JSONresult = workBookExtractor.JSONresult();

            model.addAttribute("JSONresult", JSONresult);

        } catch (IOException e) {
            model.addAttribute("JSONresult", "error\n"+e.getMessage());
            e.printStackTrace();
        }
        return "displayJSON";
    }


}
