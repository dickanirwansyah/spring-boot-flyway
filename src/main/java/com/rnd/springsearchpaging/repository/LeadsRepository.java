package com.rnd.springsearchpaging.repository;

import com.rnd.springsearchpaging.entity.Leads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, Integer> {

    @Query("select l from Leads l where l.firstname like %?1%")
    List<Leads> findLeadsByFirstname(@Param("firstname") String firstname);

    @Query("select l from Leads l where l.firstname like %?1%")
    Page<Leads> findDataLeadsByFirstname(@Param("firstname")String firstname, Pageable pageable);
}
