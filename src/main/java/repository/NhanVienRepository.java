package repository;

import domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChucVu;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private Session hss;

    public NhanVienRepository() {

        this.hss = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NhanVien nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.persist(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void update(NhanVien nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.merge(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void delete(NhanVien nv){
        Transaction transaction = this.hss.getTransaction();
        try {
            transaction.begin();
            hss.delete(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public NhanVien findById(String id){
        return this.hss.find(NhanVien.class,id);

    }
    public List<NhanVien> findAll(){
        String hql = "SELECT obj FROM NhanVien obj";
        TypedQuery<NhanVien> query = this.hss.createQuery(hql,NhanVien.class);
        List<NhanVien> list = query.getResultList();
        return list;
    }
    public NhanVien findByMa(String ma){
        String hql = "SELECT obj FROM NhanVien obj WHERE obj.Ma = ?1";
        TypedQuery<NhanVien> query = this.hss.createQuery(hql,NhanVien.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.Ma = ?1 AND nv.MatKhau = ?2";
        TypedQuery<NhanVien> query = this.hss.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
