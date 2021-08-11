package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            MemberTemp member = new MemberTemp();
            member.setName("hello");

            em.persist(member);

            em.flush();
            em.clear();

            //
            MemberTemp findMember = em.find(MemberTemp.class, member.getId());
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

//            MemberTemp member = em.find(MemberTemp.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(MemberTemp member) {
        System.out.println("member.getName() = " + member.getName());
    }

    private static void printMemberAndTeam(MemberTemp member) {
        String name = member.getName();
        System.out.println("name = " + name);

        TeamTemp team = member.getTeamTemp();
        System.out.println("team = " + team.getName());

    }
}
