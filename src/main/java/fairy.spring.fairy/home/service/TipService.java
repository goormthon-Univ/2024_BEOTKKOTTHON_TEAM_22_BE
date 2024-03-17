package fairy.spring.fairy.home.service;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;

import java.util.List;

public interface TipService {

    List<Tip> getAllTips();
    List<Tip> getTipsByCategory(Category category);
    List<Tip> searchTipsByKeyword(String keyword);
}