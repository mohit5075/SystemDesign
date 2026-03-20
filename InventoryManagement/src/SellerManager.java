import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SellerManager {
    ConcurrentHashMap<String,Seller> sellers = new ConcurrentHashMap<>();
    public void createSeller(List<String>pincodes,List<String>paymentmodes){
        Seller seller = new Seller(pincodes,paymentmodes);
        sellers.put(seller.getId(),seller);
    }
    public Seller getSeller(String id){
        return sellers.get(id);
    }
}
