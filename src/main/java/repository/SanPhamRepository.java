package repository;

import domain_model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLNsx;
import view_model.QLSanPham;

import java.util.List;

public class SanPhamRepository {
    private Session hss;

    public SanPhamRepository() {
        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(SanPham sp){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.persist(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }
    public void update(SanPham sp){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.merge(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(SanPham sp){
        Transaction transaction = hss.getTransaction();
        try {
            transaction.begin();
            this.hss.delete(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public SanPham findById(String id){
        return this.hss.find(SanPham.class,id);
    }
    public List<SanPham> findAll(){
        String hql = "SELECT obj FROM SanPham obj";
        TypedQuery<SanPham> query = this.hss.createQuery(hql,SanPham.class);
        return query.getResultList();
    }
    public SanPham findByMa(String ma){
        String hql = "SELECT obj FROM SanPham obj WHERE obj.Ma = ?1";
        TypedQuery<SanPham> query = this.hss.createQuery(hql,SanPham.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
