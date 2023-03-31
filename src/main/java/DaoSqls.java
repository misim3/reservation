// 각 dao에 맞는 sql쿼리 작성하기
// 네이버 강의 보고 작성하면 된다.

// 03.31 이거 쿼리문의 이름을 모두 다르게 해야하나? 각각의 클래스로 묵여있는데, static이라서 같아도 되겠다.
// 상품 이미지 혹은 전시 이미지 등 여러가지 값이 존재할 수 있는 경우 한 가지만 가져와야 하는지, 여러가지를 다 가져오는 것인지 확인하자.
// 그리고 한 가지만 가져오는 경우에는 파라미터를 하나 더 줘야하는 지 등 방법을 알아보자.

public class CategoryDaoSqls {
    // 카테고리 list
    public static final String SELECT_ALL = "SELECT :name FROM category";

    // 카테고리별 개수
    public static final String SELECT_COUNT = "SELECT count(*) FROM category WHERE category_id=:categoryId";
}

public class FileInfoDaoSqls {
    
    public static final String SELECT_SFN = "SELECT save_file_name FROM file_info WHERE id=:fileId";

    public static final String SELECT_FIF = "SELECT * FROM file_info WHERE id=:fileId";
}

public class ProductDaoSqls {

	public static final String SELECT_PAGING = "SELECT * FROM product WHERE category_id=:categoryId ORDER BY id DESC limit :start, :limit";

    public static final String SELECT_P = "SELECT * FROM product WHERE id=:productId";
}

public class ProductImageDaoSqls {
    
    public static final String SELECT_ALL = "SELECT * FROM product_image WHERE product_id=:productId";

    // 값을 한 가지만 가져오는 방법을 알아보자. done
    public static final String SELECT_BY_ID = "SELECT * FROM product_image WHERE product_id=:productId ORDER BY id limit 1";
}

public class ProductPriceDaoSqls {
    
    public static final String SELECT_ALL = "SELECT * FROM product_price WHERE product_id=:productId";

    public static final String SELECT_BY_ID = "SELECT price FROM product_price WHERE id=:productPriceId";
}

public class DisplayInfoDaoSqls {

    public static final String SELECT_BY_ID = "SELECT * FROM display_info WHERE id=:displayInfoId";
}

public class DisplayInfoImageDaoSqls {

    public static final String SELECT_BY_ID = "SELECT * FROM display_info_image WHERE id=:displayInfoId";
}

public class PromotionDaoSqls {

    public static final String SELECT_ALL = "SELECT * FROM promotion WHERE product_id=:productId";
}

public class ReservationDaoSqls {
    
    public static final String SELECT_ALL = "SELECT * FROM reservation_info WHERE reservation_email=:reservationEmail";

    public static final String SELECT_BY_ID = "SELECT * FROM reservation_info WHERE id=:reservationInfoId";

    // 업데이트 쿼리문 파라미터 알아보기 done
    public static final String UPDATE_BY_ID = "UPDATE reservation_info SET cancel_flag = 1 WHERE id=:reservationInfoId";
}

public class ReservationInfoPriceDaoSqls {

    public static final String SELECT_ALL = "SELECT * FROM reservation_info_price WHERE reservation_info_id=:reservationInfoId";
}

public class ReservationUserCommentDaoSqls {

    public static final String SELECT_ALL = "SELECT * FROM reservation_user_comment WHERE product_id=:productId";
}

public class ReservationUserCommentImageDaoSqls {

    public static final String SELECT_BY_ID = "SELECT * FROM reservation_user_comment_image WHERE id=:commentId";
}