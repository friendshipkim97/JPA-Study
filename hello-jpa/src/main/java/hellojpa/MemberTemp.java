package hellojpa;

import jpabook.jpashop.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

//@Entity(name = "MemberTemp")
public class MemberTemp{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

//    //Period
//    @Embedded
//    private Period period;

    //주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressEntities = new ArrayList<>();

    //주소
//    @Embedded
//    @AttributeOverrides({@AttributeOverride(name = "city",
//    column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

}
