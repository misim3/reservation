import java.util.List;

// service에서 작성한 인터페이스 내부를 구현하면 됌.
// 메소드 구현은 네이버 강의보고 하면 됌.

// 여기서 주의해야할 것은 dao로 값을 넘겨줄때, dto가 넘어가면 안된다는 것.
// 그런데 put, post 방식을 제외하면 그럴 일이 없다.
// Dao를 통해 entity를 받아와서 Mapping 클래스를 이용해서 Dto로 만들자.

@Service
public class CategoryServiceImpl implements CategoryService {

	public List<CategoryDto> getCategories() {
		List<Category> list = categoryDao.selectAll();

		List<CategoryDto> dlist = new List<CategoryDto>();

		for(int i=0; i<list.size(); i++) {
			dlist[i] = mapping.toCategoryDto(list[i]);
		}

		return dlist;
	}
}

@Service
public class ProductServiceImpl implements ProductService {

	public List<ProductDto> getProducts(Integer categoryId, Integer start) {
		List<Product> list = productDao.selectAll(categoryId, start);

		List<ProductDto> dlist = new List<ProductDto>();

		for(int i=0; i<list.size(); i++) {
			dlist[i] = mapping.toProductDto(list[i]);
		}

		return dlist;
	}

	public Integer getCount(Integer categoryId) {
		Integer count = categoryDao.selectCount(categoryId);

		return count;
	}

	public List<ProductImageDto> getProductImages(Integer displayInfoId) {
		List<ProductImage> list = productImageDao.selectById(displayInfoId);

		return list;
	}

    public List<ProductPriceDto> getProductPrices(Integer displayInfoId) {
		List<ProductPrice> list = productPriceDao.selectById(displayInfoId);

		return list;
	}
}

@Service
public class DisplayServiceImpl implements DisplayService {
	
	public DisplayInfoDto getDisplayInfo(Integer displayInfoId) {
		DisplayInfo displayInfo = displayInfoDao.selectById(displayInfoId);

		return displayInfoDto;
	}

	public ImageDto getDisplayInfoImage(Integer displayInfoId) {
		Image displayInfoImage = displayInfoImageDao.selectById(displayInfoId);

		return displayInfoImageDto;
	}
}

@Service
public class ReservationServiceImpl implements ReservationService {
    
	public List<ReservationInfoDto> getReservations(String reservationEmail) {
		List<ReservationInfo> list = reservationDao.selectAll(reservationEmail);

		return list;
	}

    public ReservationResponseDto addreservation(Map<String, Object> reservationParam, Integer clientIp) {
		// 받는 건 제대로 받아서 저장하고 반환하는 값은 Random으로 생성된 예약 객체이다.
		// 이건 남의 코드 확인해서 해보자.
	}
	/*param에 들어온 값을 map으로 접근해서 하나하나 값 찾아서 reservationResponse에 담기
	{
		"displayInfoId": 0,
		"prices": [
			{
			"count": 0,
			"productPriceId": 0,
			"reservationInfoId": 0,
			"reservationInfoPriceId": 0
			}
		],
		"productId": 0,
		"reservationEmail": "string",
		"reservationName": "string",
		"reservationTelephone": "string",
		"reservationYearMonthDay": "string"
	}
	public class ReservationInfoDto {
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
	*/
    ReservationResponseDto reservationResponseDto = reservationService.deleteReservation(ReservationId, reservationResponseDto, clientIp);
	/* 위랑 마찬가지로 처리하면 됌.
	{
		"reservationInfoId": 0,
		"productId": 20,
		"displayInfoId": 18,
		"reservationName": "Admin",
		"reservationTelephone": "010-1111-2222",
		"reservationEmail": "admin@admin.com",
		"reservationDate": "2023-03-24",
		"cancelYn": true,
		"createDate": "2023-03-24T14:53:26.8",
		"modifyDate": "2023-03-24T14:53:26.8",
		"prices": [
			{
			"reservationInfoPriceId": 67,
			"reservationInfoId": 0,
			"productPriceId": 6,
			"count": 6
			}
		]
	}
	*/
}
@Service
public class CommentServiceImpl implements CommentService {

	public List<CommentDto> getComments(Integer displayInfo) {
		List<Comment> list = commentDao.selectAll(displayInfo);

		return list;
	}
    CommentResponseDto commentResponseDto = commentService.addcomment(attachedImage, comment, productId, reservationInfoId, score, clientIp);
	/* 얘는 받아온 거 이미지 처리만하고 그대로 담아서 반환.
	{
		"commentId": 39,
		"productId": 1,
		"reservationInfoId": 1,
		"score": 1,
		"comment": "1",
		"createDate": "2023-03-24T15:05:12.607",
		"modifyDate": "2023-03-24T15:05:12.607",
		"commentImage": null
	}
	*/
}
@Service
public class PromotionServiceImpl implements PromotionService {

	public List<PromotionDto> getPromotions(){
		List<Promotion> list = promotionDao.selectAll();

		List<PromotionDto> dlist = new List<PromotionDto>();

		for(int i=0; i< list.size(); i++) {
			dlist[i] = mapping.toPromotionDto(list[i]);
		}

		return dlist;
	}
}
