package com.HostelManagementSystem.repository;

import com.HostelManagementSystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
