package fairy.spring.fairy.home.controller;


import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final TipRepository tipRepository;

    @Autowired
    public SearchController(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @GetMapping("/api/search")
    public ResponseEntity<List<Tip>> searchTips(@RequestParam("keyword") String keyword) {
        // 팁의 제목 또는 내용에 검색어가 포함되는 팁을 검색합니다.
        List<Tip> tips = tipRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
        return ResponseEntity.ok(tips);
    }
}