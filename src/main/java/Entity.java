public class Category {
    private Integer categoryId;
    private String categoryName;
}

public class FileInfo {
    private Integer fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private Integer deleteFlag;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}

public class Product {
    private Integer productId;
    private Integer categoryId;
    private String description;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}

public class DisplayInfo {
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
}

public class ProductImage {
    private Integer productImageId;
    private Integer productId;
    private String type;
    private Integer fileId;
}

public class DisplayInfoImage {
    private Integer displayInfoImageId;
    private Integer displayInfoId;
    private Integer fileId;
}

public class ProductPrice {
    private Integer productPriceId;
    private Integer productId;
    private String priceTypeName;
    private Integer price;
    private Double discountRate;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}

public class Promotion {
    private Integer promotionId;
    private Integer productId;
}

public class ReservationInfo {
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
}

public class ReservationInfoPrice {
    private Integer reservationPriceId;
    private Integer reservationInfoId;
    private Integer productPriceId;
    private Integer count;
}

public class ReservationUserComment {
    private Integer reservationUserCommentId;
    private Integer productId;
    private Integer reservationInfoId;
    private Double score;
    private String comment;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}

public class ReservationUserCommentImage {
    private Integer reservationUserCommentImageId;
    private Integer reservationInfoId;
    private Integer reservationUserCommentId;
    private Integer fileId;
}