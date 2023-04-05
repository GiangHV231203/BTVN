package repository;

import domain_model.CuaHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLCuaHang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hss;

    public CuaHangRepository() {
        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(CuaHang ch){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(CuaHang ch){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(CuaHang ch){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public CuaHang findById(String id){
        return this.hss.find(CuaHang.class,id);
    }
    public List<CuaHang> findAll(){
        String hql = "SELECT obj FROM CuaHang obj";
        TypedQuery<CuaHang> query = this.hss.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }
    public CuaHang findByMa(String ma){
        String hql = "SELECT obj FROM CuaHang obj WHERE obj.Ma = ?1";
        TypedQuery<CuaHang> query = this.hss.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
