package dto;

public class DeliveryOtpRequestDTO {
    private String deliveryEmail;

    public DeliveryOtpRequestDTO() {
        // Default constructor
    }

    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    @Override
    public String toString() {
        return "DeliveryOtpRequestDTO [deliveryEmail=" + deliveryEmail + "]";
    }
}
