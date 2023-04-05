package repository;


import domain_model.MauSac;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLMauSac;

import java.util.List;

public class MauSacRepository {

    private Session hss;

    public MauSacRepository() {

        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(MauSac ms){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }
    public void update(MauSac ms){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(MauSac ms){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public MauSac findById(String Id){
        return this.hss.find(MauSac.class,Id);
    }
    public List<MauSac> findAll(){
        String hql= "select obj from MauSac obj";
        TypedQuery<MauSac> query = this.hss.createQuery(hql,MauSac.class);
        return query.getResultList();
    }
    public MauSac findByMa(String ma){
        String hql = "SELECT obj FROM MauSac obj WHERE obj.Ma =?1";
        TypedQuery<MauSac> query = this.hss.createQuery(hql,MauSac.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }

}
