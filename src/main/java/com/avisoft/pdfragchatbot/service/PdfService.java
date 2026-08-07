package com.avisoft.pdfragchatbot.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {

    private final TokenTextSplitter splitter;

    public PdfService(TokenTextSplitter splitter){
        this.splitter = splitter;
    }

    public List<Document> read(Resource resource){
        PagePdfDocumentReader reader = new PagePdfDocumentReader(resource);

        List<Document> documents = reader.read();

        List<Document> chunks = splitter.apply(documents);

        int index = 1;

        for (Document chunk : chunks){
            System.out.println("--------------------------------");
            System.out.println("Chunk : "+index++);
            System.out.println(chunk.getText());
        }
        return chunks;
    }
}
