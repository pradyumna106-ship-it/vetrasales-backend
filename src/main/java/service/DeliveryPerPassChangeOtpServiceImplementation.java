package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.DeliveryPerPassChangeOtpRepository;

@Service
public class DeliveryPerPassChangeOtpServiceImplementation implements DeliveryPerPassChangeOtpService {
	@Autowired private DeliveryPerPassChangeOtpRepository repo;
}
