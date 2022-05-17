package hellojpa;

import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class TeamTemp extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany()
    @JoinColumn(name = "TEAM_ID")
    private List<MemberTemp> members = new ArrayList<>();

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

    public List<MemberTemp> getMembers() {
        return members;
    }

    public void setMembers(List<MemberTemp> members) {
        this.members = members;
    }
}
