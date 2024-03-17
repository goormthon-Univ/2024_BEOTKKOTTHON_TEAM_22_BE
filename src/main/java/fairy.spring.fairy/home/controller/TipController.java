package fairy.spring.fairy.home.controller; // 패키지 선언 추가

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipController {

    @Autowired
    private TipService tipService;

    @GetMapping("/tips")
    public List<Tip> getAllTips() {
        return tipService.getAllTips();
    }

    @GetMapping("/tips/category/{categoryId}")
    public List<Tip> getTipsByCategory(@PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return tipService.getTipsByCategory(category);
    }

    @GetMapping("/tips/search")
    public List<Tip> searchTipsByKeyword(@RequestParam String keyword) {
        return tipService.searchTipsByKeyword(keyword);
    }
}