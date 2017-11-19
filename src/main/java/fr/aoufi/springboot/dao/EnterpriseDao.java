package fr.aoufi.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.aoufi.springboot.model.Enterprise;

@Repository
public interface EnterpriseDao extends JpaRepository<Enterprise, Long> {

    Enterprise findByName(String name);

}