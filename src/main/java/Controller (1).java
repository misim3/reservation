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
    public Map<String, Object> getProducts(Integer categoryId, Integer start) {
        return ProductService.getAllProducts(categoryId, start);
    }
    
    // 상품 전시 정보 구하기
    @GetMapping("/products/{displayInfoId}")
    public Map<String, Object> getDisplay(Integer displayInfoId) {
        return DisplayInfoService.getDisplayInfo(displayInfoId);
    }
    
    // 예약 정보 조회
    @GetMapping("/reservations")
    public Map<String, Object> getReservations(String reservationEmail) {
        return ReservationService.getAllReservationInfos(reservationEmail);
    }

    // 예약하기
    @PostMapping("/reservations")
    public ReservationResponseDto createReservation(@RequestBody ReservationResponseDto reservationResponseDto) {
        
        String clientIp = request.getRemoteAddr();

        ReservationService.createReservation(reservationResponseDto, clientIp);

        // 유효성 검사 - ?
        
        // 랜덤 생성 예약 객체 반환
        ReservationResponseDto randomDto = new ReservationResponseDto();
        return randomDto;
    }
        
    
    // 예약 취소하기
    @PutMapping("/reservations/{reservationInfoId}")
    public ReservationResponseDto cancelReservation(Integer reservationInfoId) {

        String clientIp = request.getRemoteAddr();

        ReservationService.cancelReservation(reservationInfoId);

        // 유효성 검사

        // 랜덤 생성 예약 객체 반환
        ReservationResponseDto randomDto = new ReservationResponseDto();
        return randomDto;
    }
        
    
    // 한줄평 등록
    @PostMapping("/reservations/{reservationInfoId}/comments")
    public CommentResponseDto createComment(@RequestBody CommentResponseDto commentResponseDto) {

        CommentService.createComment(commentResponseDto);

        // 유효성 검사

        // 랜덤 생성 예약 객체 반환
        CommentResponseDto randomDto = new CommentResponseDto();
        return randomDto;
    }
    
    // 카테고리 목록 구하기
    @GetMapping("/categories")
    public List<categorieDto> getCategories() {
        return CategoryService.getAllCategories();
    }

    // 프로모션 목록 구하기
    @GetMapping("/promotions")
    public List<promotionDto> getPromotions() {
        return PromotionService.getAllPromotions();
    }
}
