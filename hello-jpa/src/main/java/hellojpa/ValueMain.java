package hellojpa;

public class ValueMain {

    public static void main(String[] args) {

        String name1 = "kim";
        String name2 = "kim";
        String name3 = new String("kim");
        String name4 = new String("kim");

        Address address1 = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");

        System.out.println("true" + (name1 == name2));
        System.out.println("true" + name1.equals(name2));
        System.out.println("true" + name3.equals(name2)); // eqauls를 오버라이딩 하지 않고,
        // true가 가능했던 이유는 String 클래스에서 문자를 비교하는 코드를 추가했기 때문이다.
        System.out.println("true" + name3.equals(name4));
        System.out.println("false" + (name3==name4));
        System.out.println("false" + address1.equals(address2));

    }

}
