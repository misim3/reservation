// 요련 느낌으로 작성하면 됌.
// api는 네이버 강의에서 제공하는 것 보고 하면 됌.
// 아래 메소드들은 api를 확인해서 작성한 것이다.

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private DisplayInfoService displayInfoService;
    
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PromotionService promotionService;
    
    // 상품 목록 구하기
    @GetMapping("/products")
    public Products getAllProducts(Integer categoryId, Integer start) {
        List<Products> getAllProducts(categoryId, start);
    }
    
    // 상품 전시 정보 구하기
    @GetMapping("/products/{displayInfoId}")
    public DisplayInfo getDisplayInfo(Integer displayInfoId) {
        DisplayDto getDisplayDtoById(displayInfoId);
    }
    
    // 예약 정보 조회
    @GetMapping("/reservations")
    public ReservationInfos getReservationInfos(String reservationEmail) {
        List<ReservationInfos> getAllReservationInfos(reservationEmail);
    }

    // 예약하기
    @PostMapping("/reservations")
    public ReservationInfo createReservation(reservationParam?) {
        // 컨트롤러
        (@RequestBody ReservationResponseDto reservationResponseDto) // 이런 방식으로 만들어도 될 것 같다.
        ReservationService.createReservation(reservationResponseDto);

        // 유효성 검사

        // 랜덤 생성 예약 객체 반환
        return random();
        // 서비스
        public Long createReservation(ReservationResponseDto reservationResponseDto) {

            ReservationInfo reservationInfo = toReservationInfo(ReservationResponseDto reservationResponseDto);
            // reservationResponseDto.getReservationPrices();
            List<ReservationInfoPrice> list = toReservationInfoPrices(List<ReservationPriceDto> prices);

            int p1 = ReservationDao.createReservationInfo(reservationInfo);
            int p2 = ReservationDao.createReservationInfoPrices(list);            
            
            if (p1 == 1 && p2 == 1) {
                // 유효성 검사
                return 1;
            }
            return 0;
        }
        // 레포지토리
        public Long createReservationInfo(ReservationInfo reservationInfo) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
			return insertAction.executeAndReturnKey(params).longValue();
        }
        public Long createReservationInfoPrices(List<ReservationInfoPrice> list) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(list);
			return insertAction.executeAndReturnKey(params).longValue();
        }
    }
    
    // 예약 취소하기
    @PutMapping("/reservations/{reservationInfoId}")
    public void cancelReservation(Integer reservationInfoId) {
        // 컨트롤러
        ReservationService.cancelReservation(reservationInfoId);

        // 유효성 검사

        // 랜덤 생성 예약 객체 반환
        return random();

        // 서비스
        public int cancelReservation(Integer reservationInfoId) {
            ReservationDao.cancelReservation(reservationInfoId);

            // 유효성 검사
        }

        // 레포지토리
        public Long cancelReservation(Integer reservationInfoId) {
            Map<String, Integer> param = Collections.singletonMap("reservationInfoId", reservationInfoId);
            return jdbc.update(UPDATE_BY_ID, param);
        }
    }
    
    // 한줄평 등록
    @PostMapping("/reservations/{reservationInfoId}/comments")
    public ? createComment(file?, String comment, Integer productId, Integer reservationInfoId, Integer score) {
        // 컨트롤러
        (@RequestBody CommentResponseDto commentResponseDto) // 이런 방식으로 만들어도 될 것 같다.
        CommentService.createComment(commentResponseDto);

        // 유효성 검사

        // 랜덤 생성 예약 객체 반환
        return random();
        // 서비스
        public Long createComment(CommentResponseDto commentResponseDto) {

            ReservationUserComment comment = toComment(CommentResponseDto commentResponseDto);
            // commentResponseDto.getImage();
            ReservationUserCommentImage image = toImage(ImageDto image);

            int p1 = CommentDao.createComment(comment);
            int p2 = CommentDao.createCommentImage(image);            
            
            if (p1 == 1 && p2 == 1) {
                // 유효성 검사
                return 1;
            }
            return 0;
        }
        // 레포지토리
        public Long createComment(ReservationUserComment comment) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
			return insertAction.executeAndReturnKey(params).longValue();
        }
        public Long createCommentImage(ReservationUserCommentImage image) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(image);
			return insertAction.executeAndReturnKey(params).longValue();
        }
    }

    // 카테고리 목록 구하기
    @GetMapping("/categories")
    public categories? getAllCategories() {
        List<CategoryDto> getAllCategories();
    }

    // 프로모션 목록 구하기
    @GetMapping("/promotions")
    public promotions? getAllPromotions() {
        list getpromotion
        id
        productId
        productimageurl
    }
}
