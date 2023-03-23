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

    // 예약하기 - random으로 생성해서 보내준다고 하는데 뭔소리인지 모르겠으니 딴 사람들이 한 것을 보고 하자.
    @PostMapping("/reservations")
    public ReservationInfo createReservation(reservationParam?) {
        addreservation
        cancelYn
        createdate
        displayInfoId
        modifydate
        prices
        productId
        reservationdate
        reservationEmail
        reservationInfoId
        reservationName;
        reservationTelephone;
    }
    
    // 예약 취소하기
    @PutMapping("/reservations/{reservationInfoId}")
    public void cancelReservation(Integer reservationInfoId) {
        cancelreservation
        cancelYn
        createdate
        displayInfoId
        modifydate
        prices
        productId
        reservationdate
        reservationEmail
        reservationInfoId
        reservationName;
        reservationTelephone;
    }
    
    // 한줄평 등록 - random으로 생성해서 보내준다고 하는데 뭔소리인지 모르겠으니 딴 사람들이 한 것을 보고 하자.
    @PostMapping("/reservations/{reservationInfoId}/comments")
    public ? createComment(file?, String comment, Integer productId, Integer reservationInfoId, Integer score) {
        addcomment
        comment
        commentid
        commentimage
        createdate
        modifydate
        productId
        reservationInfoId
        score
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
