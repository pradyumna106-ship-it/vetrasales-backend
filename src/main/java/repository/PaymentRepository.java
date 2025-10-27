package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Payment;
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
