package repository;

import domain_model.KhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLKhachHang;

import java.util.ArrayList;
import java.util.List;
public class KhachHangRepository {
    private Session hsession;


    public KhachHangRepository() {

        this.hsession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(KhachHang kh ){
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }

    }
    public void update(KhachHang kh ){
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }
    }
    public void delete(KhachHang kh){
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }
    }
    public KhachHang findById(String id){
        return this.hsession.find(KhachHang.class,id);
    }
    public List<KhachHang> findAll(){
        String hql = "SELECT obj FROM KhachHang obj";
        TypedQuery<KhachHang> query = this.hsession.createQuery(hql,KhachHang.class);
        return query.getResultList();
    }

    public KhachHang findByMa(String ma) {
        String hql = "SELECT obj FROM KhachHang obj WHERE obj.Ma = ?1";
        TypedQuery<KhachHang> query = this.hsession.createQuery(hql,KhachHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }
}
