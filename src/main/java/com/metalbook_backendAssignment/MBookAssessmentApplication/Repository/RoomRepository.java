package com.metalbook_backendAssignment.MBookAssessmentApplication.Repository;

import com.metalbook_backendAssignment.MBookAssessmentApplication.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,String> {
}
