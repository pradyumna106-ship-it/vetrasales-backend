package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDeliveryOtpRepository extends JpaRepository<CustomerDeliveryOtp, Long> {
	Optional<CustomerDeliveryOtp> findByOrderId(Long orderId);
}
