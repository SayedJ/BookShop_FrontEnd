package net.guides.springboot2.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot2.crud.model.Order;
import net.guides.springboot2.crud.model.User;



import org.springframework.stereotype.Repository;

import net.guides.springboot2.crud.model.Books;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByUser(User user);
}