// 각 dao에 맞는 sql쿼리 작성하기
// 네이버 강의 보고 작성하면 된다.

public class CategoryDaoSqls {
    // 카테고리 list
    public static final String SELECT_ALL = "SELECT name FROM category";

    // 카테고리별 개수
    public static final String SELECT_COUNT = "SELECT count(*) FROM category WHERE categoryId=:categoryId";
}

public class FileInfoDaoSqls {

}

public class ProductDaoSqls {

	public static final String SELECT_PAGING = "SELECT * FROM product WHERE categoryId=:categoryId ORDER BY id DESC limit :start, :limit";

}

public class DisplayInfoDaoSqls {
	
}

public class ProductImageDaoSqls {

}

public class DisplayInfoImageDaoSqls {
	
}

public class ProductPriceDaoSqls {

}

public class PromotionDaoSqls {
	
}

public class ReservationInfoDaoSqls {

}

public class ReservationInfoPriceDaoSqls {
	
}

public class ReservationUserCommentDaoSqls {

}

public class ReservationUserCommentImageDaoSqls {
	
}