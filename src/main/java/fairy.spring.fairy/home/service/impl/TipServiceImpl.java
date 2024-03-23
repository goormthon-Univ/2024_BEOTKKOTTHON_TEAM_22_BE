package fairy.spring.fairy.home.service.impl;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.CategoryType;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.home.service.TipService;

import java.util.ArrayList;
import java.util.List;

public class TipServiceImpl implements TipService {

    private List<Tip> tipList;

    public TipServiceImpl() {
        // Tip 정보 초기화
        this.tipList = new ArrayList<>();
        initializeTips();
    }

    private void initializeTips() {
        // JSON 데이터를 이용하여 Tip 객체 생성 후 리스트에 추가
        Tip tip = Tip.builder()
                .id(1L)
                .title("음식 간 맞추는 꿀팁")
                .categoryType(2) // Enum으로 정의된 CategoryType 사용
                .bookmarkCounts(10)
                .bookmarkStatus(false)
                .imageUrl("https://www.notion.so/5d82bd4f1daf454880995a6e5ddfaa36?pvs=4#07a2a3c3be92443da0f2064ee283924a")
                .content("1. **기본 맛 간의 이해**: 음식의 기본적인 맛 간을 이해하는 것이 중요합니다. 주로 사용되는 맛 간은 신(단), 쓴, 짠, 매운, 씹히는 맛 등이 있습니다. \n2. **균형 맞추기**:  너무 짠 음식에는 단 맛을 더해 균형을 맞출 수 있고, 너무 달콤한 음식에는 산(신 맛)을 더해 균형을 맞출 수 있습니다. \n3. **허브와 양념 사용**: 다양한 허브와 양념을 사용하여 음식에 깊이 있는 맛을 더할 수 있습니다. 예를 들어, 로즈마리는 육류 요리에 잘 어울리며, 바질은 토마토 기반 요리에 잘 어울립니다. \n4. **산성성 추가**: 산성성은 신선함을 더하고 음식의 맛을 활기차게 만들어줍니다. 식초, 레몬 주스, 토마토 소스 등을 사용하여 산성성을 추가할 수 있습니다. \n5. **양념과 향신료 조절**: 양념과 향신료를 조절하여 음식에 깊이 있는 맛을 줄 수 있습니다. 강한 향신료는 조금씩 사용하여 음식을 더 맛있게 만들 수 있습니다. \n6. **시간을 통한 개선**: 일부 음식은 조리 시간이 길수록 맛이 깊어질 수 있습니다. 차로 음식을 끓여내면서 맛을 조절하고, 시간이 지날수록 맛을 확인하여 조절할 수 있습니다.")
                .build();
        // Tip 객체를 리스트에 추가
        tipList.add(tip);
    }

    @Override
    public List<Tip> getAllTips() {
        return tipList;
    }

    @Override
    public List<Tip> getTipsByCategory(Category category) {
        return null;
    }


    public List<Tip> getTipsByCategory(CategoryType category) {
        // 여기서는 간단히 카테고리에 따라 필터링하여 반환
        List<Tip> filteredTips = new ArrayList<>();
        for (Tip tip : tipList) {
            if (category.equals(tip.getCategory())) {
                filteredTips.add(tip);
            }
        }
        return filteredTips;
    }

    @Override
    public List<Tip> searchTipsByKeyword(String keyword) {
        // 키워드를 포함하는 팁을 찾아 반환
        List<Tip> foundTips = new ArrayList<>();
        for (Tip tip : tipList) {
            if (tip.getContent().contains(keyword) || tip.getTitle().contains(keyword)) {
                foundTips.add(tip);
            }
        }
        return foundTips;
    }
}