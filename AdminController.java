@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private StatisticsService statisticsService;

    // Manage User Access
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    // Moderate Services
    @GetMapping("/services/{serviceId}/reviews")
    public List<Review> getReviewsForService(@PathVariable Long serviceId) {
        return serviceService.getReviewsForService(serviceId);
    }

    @DeleteMapping("/services/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService(serviceId);
        return ResponseEntity.ok().body("Service deleted successfully");
    }

    // Moderate Reviews
    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok().body("Review deleted successfully");
    }

    // Moderate Replies
    @GetMapping("/reviews/{reviewId}/replies")
    public List<Reply> getRepliesForReview(@PathVariable Long reviewId) {
        return reviewService.getRepliesForReview(reviewId);
    }

    @DeleteMapping("/replies/{replyId}")
    public ResponseEntity<?> deleteReply(@PathVariable Long replyId) {
        reviewService.deleteReply(replyId);
        return ResponseEntity.ok().body("Reply deleted successfully");
    }

    // View Usage Statistics
    @GetMapping("/statistics")
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }
}
