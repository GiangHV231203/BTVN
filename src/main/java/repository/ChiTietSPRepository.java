package repository;

import domain_model.ChiTietSP;
import domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChiTietSP;
import view_model.QLChucVu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    private Session hss;

    public ChiTietSPRepository() {

        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(ChiTietSP ctsp){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(ctsp);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void update(ChiTietSP ctsp){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(ctsp);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void delete(ChiTietSP ctsp){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public ChiTietSP findById(String id){
        return this.hss.find(ChiTietSP.class,id);

    }
    public List<ChiTietSP> findAll(){
        String hql = "SELECT obj FROM ChiTietSP obj";
        TypedQuery<ChiTietSP> query = this.hss.createQuery(hql,ChiTietSP.class);
        List<ChiTietSP> list = query.getResultList();
        return list;
    }
    public ChiTietSP findByTen(String ten){
        String hql = "SELECT obj FROM ChiTietSP obj WHERE obj.sanPham.Ten = ?1";
        TypedQuery<ChiTietSP> query = this.hss.createQuery(hql,ChiTietSP.class);
        query.setParameter(1,ten);
        return query.getSingleResult();
    }
}
