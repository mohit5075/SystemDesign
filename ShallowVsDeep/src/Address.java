public class Address {
    public String city;
    public String area;
    public Address(String city,String area){
        this.area = area;
        this.city = city;
    }
    public Address(Address address){
        this.city = address.city;
        this.area = address.area;
    }
}
