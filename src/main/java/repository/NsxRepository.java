package repository;



import domain_model.NSX;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLNsx;

import java.util.List;

public class NsxRepository {
    private Session hss;

    public NsxRepository() {

        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NSX nsx){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }
    public void update(NSX nsx){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(NSX nsx){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(nsx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NSX findById(String id){
        return this.hss.find(NSX.class,id);
    }
    public List<NSX> findAll(){
        String hql = "SELECT obj FROM NSX obj";
        TypedQuery<NSX> query = this.hss.createQuery(hql,NSX.class);
        return query.getResultList();

    }
    public NSX findByMa(String ma){
        String hql = "SELECT obj FROM NSX obj WHERE obj.Ma = ?1";
        TypedQuery<NSX> query = this.hss.createQuery(hql,NSX.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
