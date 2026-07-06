package com.avisoft.pdfragchatbot.controller;

import com.avisoft.pdfragchatbot.dto.UploadResponse;
import com.avisoft.pdfragchatbot.service.PdfService;
import org.springframework.ai.document.Document;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final PdfService pdfService;

    public DocumentController(PdfService pdfService){
        this.pdfService = pdfService;
    }

    @PostMapping(value = "/upload",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadResponse upload(@RequestParam("file")
                                     MultipartFile file) throws IOException{
        List<Document> documents = pdfService.read(file.getResource());

        return new UploadResponse(
                file.getOriginalFilename(),
                documents.size()
        );
    }
}
