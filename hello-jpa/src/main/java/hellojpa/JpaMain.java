package hellojpa;

import jpabook.jpashop.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            tx.commit();


        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

//    private static void printMember(MemberTemp member) {
//        System.out.println("member.getName() = " + member.getName());
//    }
//
//    private static void printMemberAndTeam(MemberTemp member) {
//        String name = member.getName();
//        System.out.println("name = " + name);
//
//        TeamTemp team = member.getTeamTemp();
//        System.out.println("team = " + team.getName());
//
//    }
}
