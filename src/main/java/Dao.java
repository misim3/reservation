import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

// 내 생각엔 selectAll(), selectbyid(), insert(), update(), deletebyid()를 구현하는 게 좋을 것 같다.
// 왜냐하면, 각 메소드에서 사용할 sql언어가 메소드이름에 들어가서 어떤 역할을 수행하는지 더 명확하게 이해할 수 있기 때문이다.
// 그리고 메소드 안의 코드 구현은 강의에 나온 NamedParameterJbdcTemplate을 사용하여 먼저 구현해보자.

// 2023.03.18 21:02 깨달았다. web api에 존재하는 기능만 컨트롤러에 구현하면 된다.
// 그리고 그 컨트롤러에 필요한 기능만 서비스에 구현하면 된다.
// 그리고 그 서비스에 필요한 기능만 dao에 구현하면 된다.
// 그리고 그 dao에 필요한 데이터 클래스만 dto에 구현하면 된다.
// 그리고 엔티티 클래스는 ddl sql쿼리를 보고 구현하면 된다.
// 그러면 기본 백엔드 구현이 끝난다. 상태유지기술, 인터셉터, 로깅, 파일업로드 다운로드 하면 완전히 끝난다.
// 그러고 나서 프론트엔드 코드를 훔쳐와서 사용하자.
// 내 생각엔 프론트엔드와 백엔드를 연결하는 부분에서 시간이 좀 걸릴 것 같다.

// 이렇게 되면, 레이어드아키텍처 스프링mvc 어노테이션 api사용법 상태유지기술 인터셉터 로깅 파일업로드&다운로드 경험.
// 여기에 추가해야 할 것 jpa 사용해서 이 프로젝트 리팩토링해보기, api구축, 로그인인증인가


// 03.24 dao master except post, put + query문 작성방법 + entity만 사용

// 03.26 쿼리문의 반환값이 정확하게 뭔지 모르겠다.
// 이건 직접 구현을 다 하고 실행시켜서 리스트인지 객체 하나인지 확인하자.

@Repository
public class CategoryDao {

    public List<category> selectAll() {
        return jdbc.query(SELECT_ALL, ,rowMapper);
    }

    public int selectCount(Integer categoryId) {
        Map<String, Integer> param = Collections.singletonMap("categoryId", categoryId);
        return jdbc.query(SELECT_COUNT, param, Integer.class);
    }
}

public class FileInfoDao {

    public String selectSFN(Integer fileId) {
        Map<String, Integer> param = Collection.singletonMap("fileId", fileId);
        return jdbc.query(SELECT_SFN, param, String.class);
    }

    public FileInfo selectFileInfo(Integer fileId) {
        Map<String, Integer> param = Collection.singletonMap("fileId", fileId);
        return jdbc.query(SELECT_FIF, param, FileInfo.class);
    }

    public List<FileInfo> selectAll(Integer fileId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("fileId", fileId);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }
}

public class ProductDao {

    public List<Product> selectAll(Integer categoryId, Integer start) {
        Map<String, Integer> params = new HashMap<>();
        params.put("categoryId", categoryId);
        params.put("start", start);
        params.put("limit", 4);
        return jdbc.query(SELECT_PAGING, params, rowMapper);
    }

    public Product selectProduct(Integer productId) {
        Map<String, Integer> param = Collection.singletonMap("productId", productId);
        return jdbc.query(SELECT_P, param, Product.class);
    }
}

public class ProductImageDao {

    public List<ProductImage> selectAllById(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }

    public Integer selectById(Integer productId) {
        Map<String, Integer> param = Collection.singletinMap("productId", productId);
        return jdbc.query(SELECT_FID, param, Integer.class);
    }
}

public class productPriceDao {

    public List<ProductPrice> selectAllById(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }

    public ProductPrice selectById(Integer productPriceId) {
        Map<String, Integer> param = Collection.singletinMap("productPriceId", productPriceId);
        return jdbc.query(SELECT_FID, param, ProductPrice.class);
    }
}

public class DisplayInfoDao {

    public DisplayInfo selectById(Integer displayInfoId) {
        Map<String, Integer> param = Collection.singletinMap("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_FID, param, DisplayInfo.class);
    }
}

public class DisplayInfoImageDao {

    public DisplayInfoImage selectById(Integer displayInfoId) {
        Map<String, Integer> param = Collection.singletinMap("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_FID, param, DisplayInfoImage.class);
    }
}

public class ReservationDao {

    public List<ReservationInfo> selectAll(String reservationEmail) {
        Map<String, String> params = new HashMap<>();
        params.put("reservationEmail", reservationEmail);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }

    public ReservationInfo selectById(Integer reservationInfoId) {
        Map<String, Integer> param = Collection.singletinMap("reservationInfoId", reservationInfoId);
        return jdbc.query(SELECT_FID, param, ReservationInfo.class);
    }
}

public class ReservationInfoPriceDao {

    public ReservationInfoPrice selectById(Integer reservationInfoId) {
        Map<String, Integer> param = Collection.singletinMap("reservationInfoId", reservationInfoId);
        return jdbc.query(SELECT_FID, param, ReservationInfoPrice.class);
    }
}

public class CommentDao {

    public List<Comment> selectById(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }
}

public class CommentImageDao {

    public ReservationUserCommentImage selectById(Integer commentId) {
        Map<String, Integer> param = Collection.singletinMap("commentId", commentId);
        return jdbc.query(SELECT_FID, param, ReservationUserCommentImage.class);
    }
}

public class PromotionDao {

    public List<Promotion> selectById(Integer displayInfoId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_BY_ID, params, rowMapper);
    }
}