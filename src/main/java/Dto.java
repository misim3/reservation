public class CategoryDto {
    private Integer categoryId;
    private String categoryName;

    // 생성자, getter, setter
}

public class FileInfoDto {
    private Integer fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private Integer deleteFlag;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter

    public void setDeleteFlag(Integer deleteFlag) {
        if (deleteFlag < 0 || deleteFlag > 1) {
            throw new IllegalArgumentException("Score must be between 0 and 5");
        }
        this.deleteFlag = deleteFlag;
    }
}

public class ProductDto {
    private Integer productId;
    private Integer categoryId;
    private String description;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter
}

public class DisplayInfoDto {
    private Integer displayInfoId;
    private Integer productId;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter
}

public class ProductImageDto {
    private Integer productImageId;
    private Integer productId;
    private String type;
    private Integer fileId;

    // 생성자, getter, setter

    public void setType(String type) {
        // type의 값은 th 썸네일, ma 메인, et 기타 가 디폴트 값이다. 새로 들어온 type이 저 범위에 존재하는 지 검사하는 if문.
        // 저 범위에 내가 새롭게 추가할 수 있지만, 추가하지 않겠다.
        if () {

        }
        this.type = type;
    }
}

public class DisplayInfoImageDto {
    private Integer displayInfoImageId;
    private Integer displayInfoId;
    private Integer fileId;

    // 생성자, getter, setter
}

public class ProductPriceDto {
    private Integer productPriceId;
    private Integer productId;
    private String priceTypeName;
    private Integer price;
    private Double discountRate;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter

    public void setPriceTypeName(String priceTypeName) {
        // 성인(A), 청소년(Y), 유아(B), 셋트(S), 장애인(D), 지역주민(C), 어얼리버드(E) 기타 다른 유형이 있다면 위와 겹치지 않게 1자로 정의하여 기입, VIP(V), R석(R), B석(B), S석(S), 평일(D)
        // 위에 해당하는 검사하는 if문.
        if () {

        }
        this.priceTypeName = priceTypeName;
    }
}

public class PromotionDto {
    private Integer promotionId;
    private Integer productId;

    // 생성자, getter, setter
}

public class ReservationInfoDto {
    private Integer reservationInfoId;
    private Integer productId;
    private Integer displayInfoId;
    private String reservationName;
    private String reservationTel;
    private String reservationEmail;
    private LocalDateTime reservationDate;
    private Integer cancelFlag;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter

    public void setCancleFlage(Integer cancelFlag) {
        // '취소 : 1, 예약 : 0'
        // 범위에 해당하는 지 검사하는 if문.
        if (cancelFlag < 0 || cancelFlag > 1) {
            
        }
        this.cancelFlag = cancelFlag;
    }
}

public class ReservationInfoPriceDto {
    private Integer reservationPriceId;
    private Integer reservationInfoId;
    private Integer productPriceId;
    private Integer count;

    // 생성자, getter, setter
}

public class ReservationUserCommentDto {
    private Integer reservationUserCommentId;
    private Integer productId;
    private Integer reservationInfoId;
    private Double score;
    private String comment;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 생성자, getter, setter

    public void setScore(Double score) {
        if (score < 0 || score > 5) {
            throw new IllegalArgumentException("Score must be between 0 and 5");
        }
        this.score = score;
    }

    // 위에서 유효성 검사를 추가한 것처럼 추가적인 필드나 로직을 구현할 수 있다.
}

public class ReservationUserCommentImageDto {
    private Integer reservationUserCommentImageId;
    private Integer reservationInfoId;
    private Integer reservationUserCommentId;
    private Integer fileId;

    // 생성자, getter, setter
}