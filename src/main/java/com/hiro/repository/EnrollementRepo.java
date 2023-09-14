package com.hiro.repository;

import com.hiro.model.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author sidof
 * @Since 01/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Repository
public interface EnrollementRepo extends JpaRepository<Enrollement,Long> {

}
