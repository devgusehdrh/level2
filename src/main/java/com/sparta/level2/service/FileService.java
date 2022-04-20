package com.sparta.level2.service;

import com.sparta.level2.repository.FileRepository;
import com.sparta.level2.model.Files;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    // 이미지 파일 정보 DB에 추가
    @Transactional
    public void save(Files files){
        Files f = new Files();
        f.setFilename(files.getFilename());
        f.setOrigFilename(files.getOrigFilename());
        f.setFilePath(files.getFilePath());

        fileRepository.save(f);
    }

}
