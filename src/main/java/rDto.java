public class ProductDto {
    private Integer displayInfoId;
    private String placeName;
    private String productContent;
    private String productDescription;
    private Integer productId;
    private String productImageUrl;
}

public class Products {
    private List<ProductDto> products;
    private Integer totalCount;
}

===============================================

public class CommentDto {
    private String comment;
    private Integer commentId;
    private List<ImageDto> commentImages;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Integer productId;
    private LocalDateTime reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private Integer score;
}

public class DisplayInfoDto {
    private Integer categoryId;
    private String categoryName;
    private LocalDateTime createDate;
    private Integer displayInfoId;
    private String email;
    private String homepage;
    private LocalDateTime modifyDate;
    private String openingHours;
    private String placeLot;
    private String placeName;
    private String placeStreet;
    private String productContent;
    private String productDescription;
    private String productEvent;
    private Integer productId;
    private String telephone;
}

public class ImageDto {
    private String contentType;
    private LocalDateTime createDate;
    private Integer deleteFlag;
    private Integer displayInfoId;
    private Integer displayInfoImageId;
    private Integer fileId;
    private String fileName;
    private LocalDateTime modifyDate;
    private String saveFileName;
}

public class ProductImageDto {
    private ImageDto imagedto;
    private String type;
}

public class productPriceDto {
    private LocalDateTime createDate;
    private Double discountRate;
    private LocalDateTime modifyDate;
    private Integer price;
    private String priceTypeName;
    private Integer productId;
    private Integer productPriceId;
}

public class Display {
    private Double averageScore;
    private List<CommentDto> comments;
    private Integer displayInfo;
    private ImageDto displayInfoImage;
    private List<ProductImageDto> productImages;
    private List<ProductPriceDto> productprices;
}

===============================================

public class ReservationInfos {
    private List<ReservationInfo> reservations;
    private Integer size;
}

public class ReservationInfo {
    private Integer cancelYn;
    private LocalDateTime createDate;
    private DisplayInfoDto displayInfo;
    private Integer displayInfoId;
    private LocalDateTime modifyDate;
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
    private Integer totalPrice;
}

===============================================

public class reservationPrice {
    private Integer count;
    private Integer productPriceId;
    private Integer reservationInfoId;
    private Integer reservationInfoPriceId;
}
//POST
public reservations {
    private Integer displayInfoId;
    private List<reservationPrice> reservationPrices;
    private Integer productId;
    private String reservationEmail;
    private String reservationName;
    private String reservationTelephone;
    private String reservationYearMonthDay;
}

===============================================
//PUT
public class ReservationId {
    private Integer cancelYn;
    private LocalDateTime createDate;
    private Integer displayInfoId;
    private LocalDateTime modifyDate;
    private List<reservationPrice> reservationPrices;
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
}

===============================================
//POST
public comments {
    private String comment;
    private Integer commentId;
    private ImageDto commentImage;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Integer productId;
    private Integer reservationInfoId;
    private Integer score;
}

===============================================

public class CategoryDto {
    private Integer count;
    private Integer categoryId;
    private String categoryName;
}

public categories {
    private List<CategoryDto> categories;
}

===============================================

public class PromotionDto {
    private Integer promotionId;
    private Integer productId;
    private String productImageUrl;
}

public promotions {
    private List<PromotionDto> promotions;
}