package com.avisoft.pdfragchatbot.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {

    public List<Document> read(Resource resource){
        PagePdfDocumentReader reader = new PagePdfDocumentReader(resource);

        List<Document> documents = reader.read();

        documents.forEach(document -> {
            System.out.println("-----------------------------");

            System.out.println(document.getText());
        });
        return documents;
    }
}
