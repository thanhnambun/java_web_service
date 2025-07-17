package java.ra.ss7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.ra.ss7.entity.Harvest;

public interface HarvestRepository extends JpaRepository<Harvest,Long> {
}
