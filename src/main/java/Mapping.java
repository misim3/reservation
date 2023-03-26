// Put, Post 제외하고 작성함.

public class ProductConverter {

    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        Integer id = product.getProductId();
        
        productDto.setDisplayInfoId(); // displayinfo by id
        productDto.setPlaceName(); // displayinfo by id
        productDto.setProductContent(product.getContent()); // product
        productDto.setProductDescription(product.getDescription()); // product
        productDto.setProductId(id); // product
        productDto.setProductImageUrl(); // productimage by id -> fileinfo by fileid
        return productDto;
    }
}

public class CommentConverter {

    public CommentDto toCommentDto(ReservationUserComment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(); // reservationUserComment
        commentDto.setCommentId(); // reservationUserComment
        commentDto.setCommentImages(); 
        // reservationUserCommentimage by reservationUserCommentId = fileid를 구한다. 
        // List<ImageDto> fileid로 imageDto 만들고 리스트에 추가
        commentDto.setCreateDate(); // reservationUserComment
        commentDto.setModifyDate(); // reservationUserComment
        commentDto.setProductId(); // reservationUserComment
        commentDto.setReservationDate(); // reservationInfo by reservationinfoid
        commentDto.setReservationEmail(); // reservationInfo by reservationinfoid
        commentDto.setReservationInfoId(); // reservationUserComment
        commentDto.setReservationName(); // reservationInfo by reservationinfoid
        commentDto.setReservationTelephone(); // reservationInfo by reservationinfoid
        commentDto.setScore(); // reservationUserComment
        return commentDto;
    }
}

public DisplayInfoDto toDisplayInfoDto(DisplayInfo displayInfo) {
    DisplayInfoDto displayInfoDto = new DisplayInfoDto();
    displayInfoDto.setCategoryId(); // Product by productId
    displayInfoDto.setCategoryName(); // Product by productId = categoryId -> Category by categoryId
    displayInfoDto.setCreateDate(); // displayInfo
    displayInfoDto.setDisplayInfoId(); // displayInfo
    displayInfoDto.setEmail(); // displayInfo
    displayInfoDto.setHomepage(); // displayInfo
    displayInfoDto.setModifyDate(); // displayInfo
    displayInfoDto.setOpeningHours(); // displayInfo
    displayInfoDto.setPlaceLot(); // displayInfo
    displayInfoDto.setPlaceName(); // displayInfo
    displayInfoDto.setPlaceStreet(); // displayInfo
    displayInfoDto.setProductContent(); // Product by productId
    displayInfoDto.setProductDescription(); // Product by productId
    displayInfoDto.setProductEvent(); // null
    displayInfoDto.setProductId(); // displayInfo
    displayInfoDto.setTelePhone(); // displayInfo
    return displayInfoDto;
}

public ImageDto toDisplayInfoImageDto(DisplayInfoImage displayInfoImage) {
    ImageDto displayInfoImageDto = new ImageDto();
    displayInfoImageDto.setContentType(); // fileinfo by fileid
    displayInfoImageDto.setCreateDate(); // fileinfo by fileid
    displayInfoImageDto.setDeleteFlag(); // fileinfo by fileid
    displayInfoImageDto.setDisplayInfoId(); // displayInfoImage
    displayInfoImageDto.setDisplayInfoImageId(); // displayInfoImage
    displayInfoImageDto.setFileId(); // displayInfoImage
    displayInfoImageDto.setFileName(); // fileinfo by fileid
    displayInfoImageDto.setModifyDate(); // fileinfo by fileid
    displayInfoImageDto.setSaveFileName(); // fileinfo by fileid
    return displayInfoImageDto;
}

public ProductImageDto toProductImageDto(ProductImage productImage) {
    ProductImageDto productImageDto = new ProductImageDto();
    productImageDto.setContentType(); // fileinfo by fileid
    productImageDto.setCreateDate(); // fileinfo by fileid
    productImageDto.setDeleteFlag(); // fileinfo by fileid
    productImageDto.setDisplayInfoId(); // displayinfo by productid
    productImageDto.setDisplayInfoImageId(); // displayinfo by productid
    productImageDto.setFileId(); // ProductImage
    productImageDto.setFileName(); // fileinfo by fileid
    productImageDto.setModifyDate(); // fileinfo by fileid
    productImageDto.setSaveFileName(); // fileinfo by fileid
    productImageDto.setType(); // ProductImage
    return productImageDto;
}

public ProductPriceDto toProductPriceDto(ProductPrice productPrice) {
    ProductPriceDto productPriceDto = new ProductPriceDto();
    productPriceDto.setCreateDate(); // productPriceDto
    productPriceDto.setDiscountRate(); // productPriceDto
    productPriceDto.setModifyDate(); // productPriceDto
    productPriceDto.setPrice(); // productPriceDto
    productPriceDto.setPriceTypeName(); // productPriceDto
    productPriceDto.setProductId(); // productPriceDto
    productPriceDto.setProductPriceId(); // productPriceDto
    return productPriceDto;
}

public ReservationInfoDto toReservationInfoDto(ReservationInfo reservationInfo) {
    ReservationInfoDto reservationInfoDto = new ReservationInfoDto();
    reservationInfoDto.setCancelYn(); // reservationInfo
    reservationInfoDto.setCreateDate(); // reservationInfo
    reservationInfoDto.setDisplayInfo();
    // displayinfoid로 displayinfo를 가져오고 이걸로 displayinfodto를 만든다.
    // 위에서 만든 함수 사용
    reservationInfoDto.setDisplayInfoId(); // reservationInfo
    reservationInfoDto.setModifyDate(); // reservationInfo
    reservationInfoDto.setProducId(); // reservationInfo
    reservationInfoDto.setReservationDate(); // reservationInfo
    reservationInfoDto.setReservationEmail(); // reservationInfo
    reservationInfoDto.setReservationInfoId(); // reservationInfo
    reservationInfoDto.setReservationName(); // reservationInfo
    reservationInfoDto.setReservationTelephone(); // reservationInfo
    reservationInfoDto.setTotalPrice();
    // reservationinfoprice by reservationInfoId
    // reservationinfoprice에서 productpriceid를 이용해서 가격을 가져오고 그 값에 count를 곱해서 계속 더하는 방식
    return reservationInfoDto;
}

public CategoryDto toCategoryDto(Category category) {
    CategoryDto categoryDto = new CategoryDto();
    int count = CategoryDao.selectCount(category.getCategoryId());
    categoryDto.setCount(count); // 직접 select by categoryid로 실행시켜서 가져와야함.
    categoryDto.setCategoryId(category.getCategoryId()); // category
    categoryDto.setCategoryName(category.getCategoryName()); // category
    return categoryDto;
}

public PromotionDto toPromotionDto(Promotion promotion) {
    PromotionDto promotionDto = new PromotionDto();
    promotionDto.setPromotionId(promotion.getPromotionId()); // promotion
    int productId = promotion.getProductId()
    promotionDto.setProducId(productId); // promotion
    String saveFileName = FileInfoDao.selectSFN(productId);
    promotionDto.setProductImageUrl(saveFileName); // Fileinfo by productid = savefilename
    return promotionDto;
}