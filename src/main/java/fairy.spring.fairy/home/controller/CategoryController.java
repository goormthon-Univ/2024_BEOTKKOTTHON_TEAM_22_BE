package fairy.spring.fairy.home.controller;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final TipService CategoryService;

    @GetMapping("/category/{categoryId}")
    public List<Tip> getTipsByCategory(@PathVariable Long categoryId) {
        // categoryId에 해당하는 카테고리를 찾아서 해당 카테고리에 속한 메모들을 반환
        Category category = new Category(); // 예시로 카테고리를 생성하여 사용
        category.setId(categoryId);
        return CategoryService.getTipsByCategory(category);
    }
}