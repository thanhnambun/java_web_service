package java.ra.ss7.service;

import java.ra.ss7.entity.Seed;
import java.util.List;

public interface SeedService {
    List<Seed> getAllSeeds();
    Seed getSeedById(Long id);
    Seed addSeed(Seed seed);
    Seed updateSeed(Long id, Seed seed);
    void deleteSeed(Long id);
}