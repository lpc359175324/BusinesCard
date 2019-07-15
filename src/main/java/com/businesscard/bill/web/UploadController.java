package com.businesscard.bill.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lpc
 */
@Controller
public class UploadController {
        @GetMapping("/upload")
        public String index() {
                return "upload";
        }


        @PostMapping("/uploadFile")
        public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
                if (file.isEmpty()) {
                        redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                        return "redirect:uploadStatus";
                }
                try {
                        // Get the file and save it somewhere
                        byte[] bytes = file.getBytes();
                        // UPLOADED_FOLDER 文件本地存储地址
                        Path path = Paths.get("\\file" + file.getOriginalFilename());
                        Files.write(path, bytes);

                        redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

                } catch (IOException e) {
                        e.printStackTrace();
                }
                return "redirect:/uploadStatus";
        }

}
