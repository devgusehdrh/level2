package com.sparta.level2.controller;

import com.sparta.level2.dto.BoardRequestDto;
import com.sparta.level2.model.Board;
import com.sparta.level2.repository.BoardRepository;
import com.sparta.level2.service.BoardService;
import com.sparta.level2.service.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.sparta.level2.model.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final FileService fileService;

    // 목록 가져오기
    @ResponseBody
    @GetMapping("/api/posts")
//    public List<Board> getPost(@RequestParam Long userId){
    public List<Board> getPost(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }



    // 게시글 세부 조회
    @ResponseBody
    @GetMapping("/api/posts/{post_id}")
    public Optional<Board> detailPost(@PathVariable Long post_id) throws Exception{

        return boardRepository.findById(post_id);
    }

    // 게시글 삭제
    @ResponseBody
    @DeleteMapping("/api/posts/{post_id}")
    public Long deletePost(@PathVariable Long post_id){
        boardRepository.deleteById(post_id);
        return post_id;
    }

    //게시글 수정
    @ResponseBody
    @PatchMapping("/api/posts/{post_id}")
    public Long updatePost(@PathVariable Long post_id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(post_id,requestDto);
    }


    // 게시글 추가
    @ResponseBody
    @PostMapping("/api/posts")
    public Board writePost(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
    // 이미지 파일 업로드
    @PostMapping("/upload")
    public String uploadFile(@RequestPart MultipartFile picture, @RequestPart Board content) throws IOException {

        Files file = new Files();

        String originFileName = picture.getOriginalFilename();

        String originFileNameExtension = FilenameUtils.getExtension(originFileName).toLowerCase();

        FilenameUtils.removeExtension(originFileName);

        File storedFile;
        String storedFileName;
        String filePath = "~/sparta/image/";
        

        do{
            storedFileName = RandomStringUtils.randomAlphanumeric(32) + "." + originFileNameExtension;
            storedFile = new File(filePath + storedFileName);
        }while(storedFile.exists());

        storedFile.getParentFile().mkdirs();
        picture.transferTo(storedFile);

        file.setFilename(storedFileName);
        file.setOrigFilename(originFileName);
        file.setFilePath(filePath);
        fileService.save(file);

        return "redirect:/";
        }
}
