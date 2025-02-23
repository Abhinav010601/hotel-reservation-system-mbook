package com.metalbook_backendAssignment.MBookAssessmentApplication.Repository;

import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}