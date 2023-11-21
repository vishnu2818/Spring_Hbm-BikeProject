package com.vinu.spring.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vinu.spring.entity.Bike;

@Repository
public class BikeRepository {

	public static Session getSession() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Bike.class);
		SessionFactory fac = con.buildSessionFactory();
		Session session = fac.openSession();
		return session;
	}

	public String saveBike(Bike bike) {
		Session session = BikeRepository.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(bike);
		transaction.commit();
		session.close();
		return "Bike Data Addad Successfully";
	}

	public List<Bike> getAll() {
		Session session = BikeRepository.getSession();
		@SuppressWarnings("unchecked")
		Query<Bike> q = session.createQuery("from Bike");
		return q.list();
	}

	public Bike getByid(int id) {
		Session session = BikeRepository.getSession();
		return session.get(Bike.class, id);
	}

	public String deleteByid(Bike bike) {
		Session session = BikeRepository.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(bike);
		transaction.commit();
		return "one record deleted";
	}

	public String updateById(Bike bike) {
		Session session = BikeRepository.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(bike);
		transaction.commit();
		return "one record updated";
	}

}