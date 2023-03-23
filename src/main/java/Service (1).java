// 요런 느낌으로 다섯개의 클래스 작성하면 됌.
// 필요한 메소드는 곰곰히 생각해서 하면 됌.
// 인터페이스만 작성하면 됌.


// 2023.03.18 21:15
// 아래는 api에서 요구한 메소드

public interface CategoryService {
    List<CategoryDto> getAllCategories();
}


public interface PromotionService {
    List<Promotion> getAllPromotions();
}

public interface ProductService {
    List<Products> getAllProducts(Integer categoryId, Integer start);
    Product getProductById(Integer productId);
    List<ProductImage> getProductImages(Integer productId);
    List<ProductPrice> getProductPrices(Integer productId);
    List<DisplayInfo> getDisplayInfos(Integer productId);
}

public interface DisplayInfoService {
    Display getDisplayDtoById(Integer displayInfoId);
    List<DisplayInfoImage> getDisplayInfoImages(Integer displayInfoId);
}

public interface ReservationService {
    List<ReservationInfos> getAllReservationInfos(String reservationEmail);
    ReservationInfo getReservationInfoById(Integer reservationInfoId);
    List<ReservationInfoPrice> getReservationInfoPrices(Integer reservationInfoId);
    ReservationUserComment getReservationUserComment(Integer reservationInfoId);
    List<ReservationUserCommentImage> getReservationUserCommentImages(Integer reservationUserCommentId);
}