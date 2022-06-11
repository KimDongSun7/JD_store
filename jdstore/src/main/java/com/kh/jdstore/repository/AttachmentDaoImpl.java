package com.kh.jdstore.repository;

import java.io.File;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.AttachmentDto;

@Repository
public class AttachmentDaoImpl implements AttachmentDao{

	@Autowired
	private SqlSession sqlSession;
	
	//저장 위치
	private File directory = new File(System.getProperty("user.home")+"/productImg");
	public AttachmentDaoImpl() {
		directory.mkdirs();
	}
	@Override
	public int save(MultipartFile attachment) throws IllegalStateException, IOException {
		int attachmentNo = sqlSession.selectOne("attachment.sequence");
		
		String fileName = String.valueOf(attachmentNo);
		File target = new File(directory, fileName);
		attachment.transferTo(target);
		
		sqlSession.insert("attachment.insert", AttachmentDto.builder()
														.attachmentNo(attachmentNo)
														.attachmentUpload(attachment.getOriginalFilename())
														.attachmentSave(fileName)
														.attachmentType(attachment.getContentType())
														.attachmentSize(attachment.getSize())
													.build());
		return attachmentNo;
	}

}
