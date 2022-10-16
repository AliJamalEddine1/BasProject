package com.AJD.filemngt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.AJD.filemngt.ResponseData;
import com.AJD.filemngt.entity.Attachment;
import com.AJD.filemngt.service.AttachmentService;

@RequestMapping("/image")
@RestController
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload/{cid}/{pid}")
    public ResponseData uploadFile(@RequestBody MultipartFile file,@PathVariable int cid,@PathVariable int pid) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file,cid,pid);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId()+"")
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }
    @PostMapping("/update/{pid}")
    public int updateImage(@RequestBody MultipartFile file,@PathVariable int pid) throws Exception {
        
       

        return attachmentService.updateAttachment(file,pid);
    }
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
    @GetMapping("/getImages/{clientId}")
    public ResponseEntity<List<Attachment>> getFiles(@PathVariable int clientId) throws Exception {
      /*  List<Attachment> attachment = null;
      ResponseEntity<Resource> res=new ArrayList<>();
        attachment = attachmentService.getCAttachment(clientId);
        for(Attachment a : attachment){res.add(ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(a.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + a.getFileName()
                + "\"")
                .body(new ByteArrayResource(a.getData())));}
        return res ;*/
    	List<Attachment> attach= attachmentService.getCAttachment(clientId);
    	
    
          return ResponseEntity.status(HttpStatus.OK).body(attach);
    }
    @GetMapping("/getImage/{productId}")
    public ResponseEntity<Attachment> getFile(@PathVariable int productId) throws Exception {
      /*  List<Attachment> attachment = null;
      ResponseEntity<Resource> res=new ArrayList<>();
        attachment = attachmentService.getCAttachment(clientId);
        for(Attachment a : attachment){res.add(ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(a.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + a.getFileName()
                + "\"")
                .body(new ByteArrayResource(a.getData())));}
        return res ;*/
    	Attachment attach= attachmentService.getPAttachment(productId);
    	
    
          return ResponseEntity.status(HttpStatus.OK).body(attach);
    }
    @GetMapping("/getPublicImage/{productId}")
    public ResponseEntity<Attachment> getFil(@PathVariable int productId) throws Exception {
      /*  List<Attachment> attachment = null;
      ResponseEntity<Resource> res=new ArrayList<>();
        attachment = attachmentService.getCAttachment(clientId);
        for(Attachment a : attachment){res.add(ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(a.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + a.getFileName()
                + "\"")
                .body(new ByteArrayResource(a.getData())));}
        return res ;*/
    	Attachment attach= attachmentService.getPAttachment(productId);
    	
    
          return ResponseEntity.status(HttpStatus.OK).body(attach);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Attachment>> getAll() throws Exception {
      /*  List<Attachment> attachment = null;
      ResponseEntity<Resource> res=new ArrayList<>();
        attachment = attachmentService.getCAttachment(clientId);
        for(Attachment a : attachment){res.add(ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(a.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + a.getFileName()
                + "\"")
                .body(new ByteArrayResource(a.getData())));}
        return res ;*/
    	List<Attachment> attach= attachmentService.getAll();
    	
    
          return ResponseEntity.status(HttpStatus.OK).body(attach);
    }
}
