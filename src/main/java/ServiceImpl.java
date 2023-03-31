import java.util.List;

// service에서 작성한 인터페이스 내부를 구현하면 됌.
// 메소드 구현은 네이버 강의보고 하면 됌.

// 여기서 주의해야할 것은 dao로 값을 넘겨줄때, dto가 넘어가면 안된다는 것.
// 그런데 put, post 방식을 제외하면 그럴 일이 없다.
// Dao를 통해 entity를 받아와서 Mapping 클래스를 이용해서 Dto로 만들자.

// 03.31 mapping 함수에서 entity를 dto로 변환하는 데, 이때 이 함수 안에서 나머지 entity를 불러와 dto를 완성할지
// 아니면 서비스에서 전체 entity를 불러와서 mapping 함수에 넣어서 완성할지
// 일단 전자로 구현함.

@Service
public class CategoryServiceImpl implements CategoryService {

	public List<String> getCategories() {
		List<String> list = categoryDao.selectAll();

		return list;
	}
}

@Service
public class ProductServiceImpl implements ProductService {

	public List<ProductDto> getAllProducts(Integer categoryId, Integer start) {
		List<Product> elist = productDao.selectAll(categoryId, start);

		List<ProductDto> dlist = new List<ProductDto>();

		for(int i=0; i<elist.size(); i++) {
			dlist[i] = mapping.toProductDto(elist[i]);
		}

		int totalCount = categorieDao.selectCount(categoryId);

		Map<String, Object> result = new HashMap<>();
		result.put("items", dlist);
		result.put("totalCount", totalCount);

		return result;
	}
}

@Service
public class DisplayServiceImpl implements DisplayService {
	
	public Map<String, Object> getDisplayInfo(Integer displayInfoId) {
		
		DisplayInfoDto displayInfoDto = mapping.toDisplayInfoDto(displayInfoDao.selectById(displayInfoId));

		List<Comment> ecomments = commentDao.selectAll();
		List<CommentDto> dcomments = new List<CommentDto>();
		double averageScore = 0;
		for(int i=0; i<ecomments.size(); i++) {
			averageScore += ecomments.getScore();
			dcomments[i] = mapping.toCommentDto(ecomments[i]);
		}
		averageScore /= ecomments.size();

		List<DisplayInfoImage> eDisplayImages = displayInfoImage.selectAll();
		List<ImageDto> dDisplayImages = new List<ImageDto>();
		for(int i=0; i<eDisplayImages.size(); i++) {
			dDisplayImages[i] = mapping.toDisplayInfoImageDto(eDisplayImages[i]);
		}

		List<ProductImage> eproductImages = productImageDao.selectAll(displayInfoDto.getProductId());
		List<ProductImageDto> dproductImages = new List<ProductImageDto>();
		for(int i=0; i<eproductImages.size(); i++) {
			dproductImages[i] = mapping.toProductImageDto(eproductImages[i]);
		}

		List<ProductPrice> eproductPrices = productPriceDao.selectAll();
		List<ProductPriceDto> dprodcutPrices = new List<ProductPriceDto>();
		for(int i=0; i<eproductPrices.size(); i++) {
			dprodcutPrices[i] = mapping.toProductPriceDto(eproductPrices[i]);
		}

		Map<String, Object> result = new HashMap<>();
		result.put("averageScore", averageScore);
		result.put("comments", dcomments);
		result.put("displayInfo", displayInfoDto);
		result.put("displayInfoImage", dDisplayImages);
		result.put("productImages", dproductImages);
		result.put("prodcutPrices", dprodcutPrices);

		return result;
	}
}

@Service
public class ReservationServiceImpl implements ReservationService {
    
	public Map<String, Object> getAllReservationInfos(String reservationEmail) {

		List<ReservationInfo> elist = reservationDao.selectAll(reservationEmail);
		List<ReservationInfoDto> dlist = new List<ReservationInfoDto>();
		for(int i=0; i<elist.size(); i++) {
			dlist[i] = mapping.toReservationInfoDto(elist[i]);
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("reservations", dlist);
		result.put("size", dlist.size());
	}

    public void createReservation(ReservationResponseDto reservationResponseDto, String clientIp) {
		// 받는 건 제대로 받아서 저장하고 반환하는 값은 Random으로 생성된 예약 객체이다.
		// 이건 남의 코드 확인해서 해보자.
		ReservationInfo reservationInfo = toReservationInfo(reservationResponseDto);
		List<ReservationPriceDto> prices = reservationResponseDto.getReservationPrices();
		List<ReservationInfoPrice> plist = new List<ReservationInfoPrice>();
		for(int i=0; i<prices.size(); i++) {
			plist[i] = toReservationInfoPrices(prices[i]);
		}
		
		int p1 = ReservationDao.createReservationInfo(reservationInfo);
		int p2 = ReservationDao.createReservationInfoPrices(plist);          
	}
	
	public int cancelReservation(Integer reservationInfoId) {
		return ReservationDao.cancelReservation(reservationInfoId);
	}
}

@Service
public class CommentServiceImpl implements CommentService {
    public void createComment(CommentResponseDto commentResponseDto) {

		ReservationUserComment comment = toComment(commentResponseDto);
		ReservationUserCommentImage image = toImage(commentResponseDto.getImageDto()); // imageid, fileid만 저장
		image.setReservationInfoId(comment.getReservationInfoId());
		image.setCommentId(comment.getCommentId());

		int p1 = CommentDao.createComment(comment);
		int p2 = CommentDao.createCommentImage(image);            
	}
}

@Service
public class PromotionServiceImpl implements PromotionService {

	public List<PromotionDto> getAllPromotions(){
		List<Promotion> elist = promotionDao.selectAll();

		List<PromotionDto> dlist = new List<PromotionDto>();

		for(int i=0; i< elist.size(); i++) {
			dlist[i] = mapping.toPromotionDto(elist[i]);
		}

		return dlist;
	}
}
