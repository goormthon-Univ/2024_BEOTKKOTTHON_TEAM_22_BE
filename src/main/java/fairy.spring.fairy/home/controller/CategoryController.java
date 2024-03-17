package fairy.spring.fairy.home.controller;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private TipService memoService;

    @GetMapping("/memos/{categoryId}")
    public List<Tip> getMemosByCategory(@PathVariable Long categoryId) {
        // categoryId에 해당하는 카테고리를 찾아서 해당 카테고리에 속한 메모들을 반환
        Category category = new Category(); // 예시로 카테고리를 생성하여 사용
        category.setId(categoryId);
        return memoService.getTipsByCategory(category);
    }
}