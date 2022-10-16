package com.AJD.filemngt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.AJD.filemngt.entity.Attachment;
import com.AJD.filemngt.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file,int c,int p) throws Exception {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                + fileName);
            }

            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(), c,p,
                    file.getBytes()
                   );
            return attachmentRepository.save(attachment);

       } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
       }
    }
    @Override
    public int updateAttachment(MultipartFile file,int p) throws Exception {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                + fileName);
            }

            
            return attachmentRepository.updateImage(file.getBytes(),fileName,p);

       } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
       }
    }

    @Override
    public Attachment getAttachment(int fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
    @Override
    public List<Attachment> getCAttachment(int clientId) throws Exception {
        return attachmentRepository
                .findByClientId(clientId);
                
    }
    @Override
    public Attachment getPAttachment(int productId) throws Exception {
        return attachmentRepository
                .findByProductId(productId);
                
    }
    @Override
    public List<Attachment> getAll() throws Exception {
        return attachmentRepository
                .findAll();
                
    }
}
