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

@Repository
public class CategoryDao {

    // 카테고리 전체를 가지고 오는 역할 -> 카테고리 개수, 이름
    // 카테고리 아이디로 카테고리 이름 가져오는 역할

    selectAll
    selectById

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class FileInfoDao {

    // 파일정보 아이디를 통해서 특정 파일정보 한 가지를 가져오는 역할

    selectByfileId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ProductDao {
    
    // 상품 아이디를 통해 특정 상품 한 가지를 가져오는 역할
    // 카테고리 아이디를 통해 그 카테고리에 해당하는 상품의 갯수 구하는 역할

    selectById
    selectCountByCategoryId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class DisplayInfoDao {
    
    // 상품 아이디를 통해 특정 상품 전시정보 가져오는 역할

    selectByProductId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ProductImageDao {
    
    // 상품 아이디를 통해 특정 상품 이미지 가져오는 역할

    selectByProductId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class DisplayInfoImageDao {
    
    // 전시정보 아이디를 통해 특정 전시정보 이미지 가져오는 역할

    selectByDisplayInfoId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ProductPriceDao {
    
    // 상품 아이디를 통해 특정 상품 가격 가져오는 역할

    selectAllByProductId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class PromotionDao {
    
    // 상품 아이디를 통해 특정 프로모션 아이디 가져오는 역할

    selectByProductId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ReservationInfoDao {
    
    // 상품 아이디를 통해 특정 예약정보 가져오는 역할
    // 예약 이메일을 통해 나의 예매내역 가져오는 역할

    selectByProductId
    selectAllByReservationEmail

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ReservationInfoPriceDao {
    
    // 예약정보 아이디를 통해 특정 예약가격 가져오는 역할

    selectAllByReservationInfoId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ReservationUserCommentDao {
    
    // 상품 아이디를 통해 전체 상품 한줄평 가져오는 역할

    selectAllByProductId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}

@Repository
public class ReservationUserCommentImageDao {
    
    // 예약 한줄평 아이디를 통해 특정 예약 한줄평 이미지 가져오는 역할

    selectByReservationUserCommentId

    // 유지보수 관점에서 필요한 메소드
    // 새로운 카테고리 추가
    // 카테고리 정보 업데이트
    // 카테고리 삭제
}