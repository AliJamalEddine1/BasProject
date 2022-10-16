package com.AJD.filemngt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.AJD.filemngt.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
	List<Attachment> findByClientId(int clientId);
	Attachment findByProductId(int productId);
	@Modifying
	@Query("update Attachment a set a.data = ?1, a.fileName = ?2 where a.id = ?3")
	int updateImage(byte[] data, String fileName, Integer id);
	
}
