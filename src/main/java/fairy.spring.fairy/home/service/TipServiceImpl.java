package fairy.spring.fairy.home.service;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImpl implements TipService {

    @Autowired
    private TipRepository tipRepository;

    @Override
    public List<Tip> getAllTips() {
        return tipRepository.findAll();
    }

    @Override
    public List<Tip> getTipsByCategory(Category category) {
        return tipRepository.findByCategory(category);
    }

    @Override
    public List<Tip> searchTipsByKeyword(String keyword) {
        return tipRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}