// 요런 느낌으로 다섯개의 클래스 작성하면 됌.
// 필요한 메소드는 곰곰히 생각해서 하면 됌.
// 인터페이스만 작성하면 됌.


// 2023.03.18 21:15
// 아래는 api에서 요구한 메소드

public interface CategoryService {
    List<CategoryDto> getAllCategories();//
}


public interface PromotionService {
    List<PromotionDto> getAllPromotions();//
}

public interface ProductService {
    Map<String, Object> getAllProducts(Integer categoryId, Integer start);//
}

public interface DisplayInfoService {
    Map<String, Object> getDisplayDto(Integer displayInfoId);//
}

public interface ReservationService {
    Map<String, Object> getAllReservationInfos(String reservationEmail);//
    void createReservation(ReservationResponseDto reservationResponseDto, String clientIp);//
    void cancelReservation(Integer reservationInfoId);//
 }

public interface CommentService {
    CommentResponseDto createComment(CommentResponseDto commentResponseDto);//
}