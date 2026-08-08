package com.avisoft.pdfragchatbot.dto;

public record UploadResponse(
        String filename,
        int chunkCount,
        String message
) {
}
