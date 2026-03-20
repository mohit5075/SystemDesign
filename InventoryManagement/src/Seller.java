import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Seller {
    private HashSet<String> pincodes = new HashSet<>();
    private HashSet<String> paymentModes = new HashSet<>();
    private String id;
    public Seller(List<String>pincodeList,List<String>paymentModeList){
        this.id = UUID.randomUUID().toString();
        pincodes.addAll(pincodeList);
        paymentModes.addAll(paymentModeList);
    }

    public HashSet<String> getPincodes() {
        return pincodes;
    }

    public void setPincodes(HashSet<String> pincodes) {
        this.pincodes = pincodes;
    }

    public HashSet<String> getPaymentModes() {
        return paymentModes;
    }

    public void setPaymentModes(HashSet<String> paymentModes) {
        this.paymentModes = paymentModes;
    }

    public String getId() {
        return id;
    }
}
