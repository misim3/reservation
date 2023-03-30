// Put, Post 제외하고 작성함.

public class ProductConverter {

    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        Integer productId = product.getProductId();
        DisplayInfo displayInfo = DisplayInfoDao.selectById(productId);
        productDto.setDisplayInfoId(displayInfo.getDisplayInfoId()); // displayinfo by id
        productDto.setPlaceName(displayInfo.getPlaceName()); // displayinfo by id
        productDto.setProductContent(product.getContent()); // product
        productDto.setProductDescription(product.getDescription()); // product
        productDto.setProductId(productId); // product
        int fileId = ProductImageDao.selectById(productId);
        String saveFileName = FileInfoDao.selectSFN(fileId);
        productDto.setProductImageUrl(saveFileName); // productimage by id -> fileinfo by fileid
        return productDto;
    }
}

public class CommentConverter {

    public CommentDto toCommentDto(ReservationUserComment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(comment.getComment()); // reservationUserComment
        int commentId = comment.getCommentId();
        commentDto.setCommentId(commentId); // reservationUserComment
        commentDto.setCommentImages(); 
        ReservationUserCommentImage reservationUserCommentImage = ReservationUserCommentImageDao.selectById(commentId);
        List<ImageDto> Images = FileInfoDao.selectAll(reservationUserCommentImage.getFileId());
        // reservationUserCommentimage by reservationUserCommentId = fileid를 구한다. 
        // List<ImageDto> fileid로 imageDto 만들고 리스트에 추가
        commentDto.setCreateDate(comment.getCreateDate()); // reservationUserComment
        commentDto.setModifyDate(comment.getModifyDate()); // reservationUserComment
        commentDto.setProductId(comment.getProductId()); // reservationUserComment
        int reservationInfoId = comment.getReservationInfoId();
        ReservationInfo reservationInfo = ReservationInfoDao.selectById(reservationInfoId);
        commentDto.setReservationDate(reservationInfo.getReservationDate()); // reservationInfo by reservationinfoid
        commentDto.setReservationEmail(reservationInfo.getReservationEmail); // reservationInfo by reservationinfoid
        commentDto.setReservationInfoId(reservationInfoId); // reservationUserComment
        commentDto.setReservationName(reservationInfo.getReservationName); // reservationInfo by reservationinfoid
        commentDto.setReservationTelephone(reservationInfo.getReservationTel); // reservationInfo by reservationinfoid
        commentDto.setScore(comment.getScore()); // reservationUserComment
        return commentDto;
    }
}

public DisplayInfoDto toDisplayInfoDto(DisplayInfo displayInfo) {
    DisplayInfoDto displayInfoDto = new DisplayInfoDto();
    int productId = displayInfo.getProductId();
    Product product = ProductDao.selectProduct(productId);
    displayInfoDto.setCategoryId(product.getCategoryId()); // Product by productId
    displayInfoDto.setCategoryName(product.getCategoryName()); // Product by productId = categoryId -> Category by categoryId
    displayInfoDto.setCreateDate(displayInfo.getCreateDate()); // displayInfo
    displayInfoDto.setDisplayInfoId(displayInfo.getDisplayInfoId()); // displayInfo
    displayInfoDto.setEmail(displayInfo.getEmail()); // displayInfo
    displayInfoDto.setHomepage(displayInfo.getHomepage()); // displayInfo
    displayInfoDto.setModifyDate(displayInfo.getModifyDate()); // displayInfo
    displayInfoDto.setOpeningHours(displayInfo.getOpeningHours()); // displayInfo
    displayInfoDto.setPlaceLot(displayInfo.getPlaceLot()); // displayInfo
    displayInfoDto.setPlaceName(displayInfo.getPlaceName()); // displayInfo
    displayInfoDto.setPlaceStreet(displayInfo.getPlaceStreet()); // displayInfo
    displayInfoDto.setProductContent(product.getContent()); // Product by productId
    displayInfoDto.setProductDescription(product.getDescription()); // Product by productId
    displayInfoDto.setProductEvent(); // null
    displayInfoDto.setProductId(productId); // displayInfo
    displayInfoDto.setTelePhone(displayInfo.getTelePhone()); // displayInfo
    return displayInfoDto;
}

public ImageDto toDisplayInfoImageDto(DisplayInfoImage displayInfoImage) {
    ImageDto displayInfoImageDto = new ImageDto();
    int fileId = displayInfoImage.getFileId();
    FileInfo fileInfo = FileInfoDao.selectFileInfo(fileId);
    displayInfoImageDto.setContentType(fileInfo.getContentType()); // fileinfo by fileid
    displayInfoImageDto.setCreateDate(fileInfo.getCreateDate()); // fileinfo by fileid
    displayInfoImageDto.setDeleteFlag(fileInfo.getDeleteFlag()); // fileinfo by fileid
    displayInfoImageDto.setDisplayInfoId(displayInfoImage.getDisplayInfoId()); // displayInfoImage
    displayInfoImageDto.setDisplayInfoImageId(displayInfoImage.getDisplayInfoImageId()); // displayInfoImage
    displayInfoImageDto.setFileId(fileId); // displayInfoImage
    displayInfoImageDto.setFileName(fileInfo.getFileName()); // fileinfo by fileid
    displayInfoImageDto.setModifyDate(fileInfo.getModifyDate()); // fileinfo by fileid
    displayInfoImageDto.setSaveFileName(fileInfo.getSaveFileName()); // fileinfo by fileid
    return displayInfoImageDto;
}

public ProductImageDto toProductImageDto(ProductImage productImage) {
    ProductImageDto productImageDto = new ProductImageDto();
    int fileId = productImage.getFileId();
    FileInfo fileInfo = FileInfoDao.selectFileInfo(fileId);
    productImageDto.setContentType(fileInfo.getContentType()); // fileinfo by fileid
    productImageDto.setCreateDate(fileInfo.getCreateDate()); // fileinfo by fileid
    productImageDto.setDeleteFlag(fileInfo.getDeleteFlag()); // fileinfo by fileid
    productImageDto.setDisplayInfoId(); // displayinfo by productid
    productImageDto.setDisplayInfoImageId(); // displayinfo by productid
    productImageDto.setFileId(fileId); // ProductImage
    productImageDto.setFileName(fileInfo.getFileName()); // fileinfo by fileid
    productImageDto.setModifyDate(fileInfo.getModifyDate()); // fileinfo by fileid
    productImageDto.setSaveFileName(fileInfo.getSaveFileName()); // fileinfo by fileid
    productImageDto.setType(productImage.getType()); // ProductImage
    return productImageDto;
}

public ProductPriceDto toProductPriceDto(ProductPrice productPrice) {
    ProductPriceDto productPriceDto = new ProductPriceDto();
    productPriceDto.setCreateDate(productPrice.getCreateDate()); // productPrice
    productPriceDto.setDiscountRate(productPrice.getDiscountRate()); // productPrice
    productPriceDto.setModifyDate(productPrice.getModifyDate()); // productPrice
    productPriceDto.setPrice(productPrice.getPrice()); // productPrice
    productPriceDto.setPriceTypeName(productPrice.getPriceTypeName()); // productPrice
    productPriceDto.setProductId(productPrice.getProductId()); // productPrice
    productPriceDto.setProductPriceId(productPrice.getProductPriceId()); // productPrice
    return productPriceDto;
}

public ReservationInfoDto toReservationInfoDto(ReservationInfo reservationInfo) {
    ReservationInfoDto reservationInfoDto = new ReservationInfoDto();
    reservationInfoDto.setCancelYn(reservationInfo.getCancelFlag()); // reservationInfo
    reservationInfoDto.setCreateDate(reservationInfo.getCreateDate()); // reservationInfo
    int displayInfoId = reservationInfo.getDisplayInfoId();
    DisplayInfo displayInfo = DisplayInfoDao.selectById(displayInfoId);
    reservationInfoDto.setDisplayInfoDto(mapping.toDisplayInfoDto(displayInfo));
    // displayinfoid로 displayinfo를 가져오고 이걸로 displayinfodto를 만든다.
    // 위에서 만든 함수 사용
    reservationInfoDto.setDisplayInfoId(displayInfoId); // reservationInfo
    reservationInfoDto.setModifyDate(reservationInfo.getModifyDate()); // reservationInfo
    reservationInfoDto.setProducId(reservationInfo.getProductId()); // reservationInfo
    reservationInfoDto.setReservationDate(reservationInfo.getReservationDate()); // reservationInfo
    reservationInfoDto.setReservationEmail(reservationInfo.getReservationEmail()); // reservationInfo
    int reservationInfoId = reservationInfo.getReservationInfoId();
    reservationInfoDto.setReservationInfoId(reservationInfoId); // reservationInfo
    reservationInfoDto.setReservationName(reservationInfo.getReservationName()); // reservationInfo
    reservationInfoDto.setReservationTelephone(reservationInfo.getReservationTel()); // reservationInfo
    int totalPrice = 0;
    ReservationInfoPrice reservationInfoPrice = ReservationInfoPriceDao.selectById(reservationInfoId);
    ProductPrice productPrice = ProductPriceDao.selectById(reservationInfoPrice.getProductPriceId());
    totalPrice += productPrice * reservationInfoPrice.getCount();
    reservationInfoDto.setTotalPrice(totalPrice);
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
    int fileId = ProductImageDao.selectById(productId);
    String saveFileName = FileInfoDao.selectSFN(fileId);
    promotionDto.setProductImageUrl(saveFileName); // productimage by id -> fileinfo by fileid
    return promotionDto;
}