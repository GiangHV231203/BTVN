package repository;


import domain_model.DongSP;
import domain_model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLDongSP;

import java.util.List;
import java.util.List;

public class DongSPRepository {
    private Session hss;

    public DongSPRepository() {
        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(DongSP dongSP){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.persist(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }
    public void update(DongSP dongSP){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.merge(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(DongSP dongSP){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.delete(dongSP);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public DongSP findById(String id){
        return this.hss.find(DongSP.class,id);
    }
    public List<DongSP> findAll(){
        String hql = "SELECT obj FROM DongSP obj";
        TypedQuery<DongSP> query = this.hss.createQuery(hql,DongSP.class);
        return query.getResultList();
    }
    public DongSP findByMa(String ma){
        String hql = "SELECT obj FROM DongSP obj WHERE obj.Ma = ?1";
        TypedQuery<DongSP> query = this.hss.createQuery(hql,DongSP.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
