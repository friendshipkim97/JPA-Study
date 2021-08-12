package hellojpa;

import jpabook.jpashop.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "MemberTemp")
public class MemberTemp{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private TeamTemp teamTemp;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();

    //Period
    @Embedded
    private Period period;

    //주소
    @Embedded
    private Address homeAddress;

    //주소
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city",
    column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamTemp getTeamTemp() {
        return teamTemp;
    }

    public void setTeamTemp(TeamTemp teamTemp) {
        this.teamTemp = teamTemp;
    }

//    public Locker getLocker() {
//        return locker;
//    }
//
//    public void setLocker(Locker locker) {
//        this.locker = locker;
//    }
}
