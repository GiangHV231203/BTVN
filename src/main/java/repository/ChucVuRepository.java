package repository;

import domain_model.ChucVu;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChucVu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hss;

    public ChucVuRepository() {
        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(ChucVu cv){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.persist(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(ChucVu cv){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.merge(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(ChucVu cv){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.delete(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public ChucVu findById(String id){
        return this.hss.find(ChucVu.class,id);
    }
    public List<ChucVu> findAll(){
        String hql = "SELECT obj FROM ChucVu obj";
        TypedQuery<ChucVu> query = this.hss.createQuery(hql,ChucVu.class);
        return query.getResultList();
    }
    public ChucVu findByMa(String ma){
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.Ma = ?1";
        TypedQuery<ChucVu> query = this.hss.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
