package com.edfeff.uploading.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

/**
 * @author wangpp
 */
@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping( "/" )
    public String handleFileUpload(@RequestParam( "file" ) MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message", "success uploaded " + file.getOriginalFilename());
        return "redirect:/";
    }

    @GetMapping( "/" )
    public String listUploadFiles(Model model, HttpServletResponse response) {
        model.addAttribute("files",
//                将path转成实际的可以下载的uri
                storageService.loadAll()
                        .map(path -> MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toUri().toString()
                        ).collect(Collectors.toList())
        );

        return "uploadForm";
    }

    @GetMapping( "/files/{filename:.+}" )
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable( name = "filename" ) String filename) {
        //下载文件
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
