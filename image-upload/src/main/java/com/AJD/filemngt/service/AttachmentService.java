package com.AJD.filemngt.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.AJD.filemngt.entity.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file,int c,int p) throws Exception;

    Attachment getAttachment(int fileId) throws Exception;
    List<Attachment> getCAttachment(int clientId) throws Exception;
   Attachment getPAttachment(int productId) throws Exception;
   List<Attachment> getAll() throws Exception;
   int updateAttachment(MultipartFile file,int p) throws Exception;
}
