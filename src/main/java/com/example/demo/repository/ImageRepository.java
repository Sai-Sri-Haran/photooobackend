package com.example.demo.repository;

import com.example.demo.model.ImageModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface ImageRepository extends JpaRepository<ImageModel,Long>{
	
}
