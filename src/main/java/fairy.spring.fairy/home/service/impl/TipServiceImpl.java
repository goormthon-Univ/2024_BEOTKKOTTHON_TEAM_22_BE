package fairy.spring.fairy.home.service.impl;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.repository.TipRepository;
import fairy.spring.fairy.home.service.TipService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImpl implements TipService {

//    @Autowired
//    private TipRepository tipRepository;

    @Override
    public List<Tip> getAllTips() {
        return Collections.emptyList();
//        return tipRepository.findAll();
    }

    @Override
    public List<Tip> getTipsByCategory(Category category) {
        return Collections.emptyList();
//        return tipRepository.findByCategory(category);
    }

    @Override
    public List<Tip> searchTipsByKeyword(String keyword) {
        return Collections.emptyList();
//        return tipRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }

}
