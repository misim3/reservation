// createdate, modifydate는 일단 기본생성자로 생성되면 바로 현재 시간 할당

public class ProductDto {
    private Integer displayInfoId;
    private String placeName;
    private String productContent;
    private String productDescription;
    private Integer productId;
    private String productImageUrl;
}

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

public class ProductImageDto extends ImageDto{
    private String type;
}

public class ProductPriceDto {
    private LocalDateTime createDate;
    private Double discountRate;
    private LocalDateTime modifyDate;
    private Integer price;
    private String priceTypeName;
    private Integer productId;
    private Integer productPriceId;
}

public class ReservationInfoDto {
    private Integer cancelYn;
    private LocalDateTime createDate;
    private DisplayInfoDto displayInfodto;
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

//Post, Put
public class ReservationPriceDto {
    private Integer count;
    private Integer productPriceId;
    private Integer reservationInfoId;
    private Integer reservationInfoPriceId;
}

public class ReservationResponseDto {
    private Integer cancelYn;
    private LocalDateTime createDate;
    private Integer displayInfoId;
    private LocalDateTime modifyDate;
    private List<ReservationPriceDto> prices; //
    private Integer productId;
    private String reservationDate;
    private String reservationEmail;
    private Integer reservationInfoId;
    private String reservationName;
    private String reservationTelephone;
}

//POST
public class CommentResponseDto {
    private String comment;
    private Integer commentId;
    private ImageDto commentImage;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Integer productId;
    private Integer reservationInfoId;
    private Integer score;
}

public class CategoryDto {
    private Integer count;
    private Integer categoryId;
    private String categoryName;
}

public class PromotionDto {
    private Integer promotionId;
    private Integer productId;
    private String productImageUrl;
}
