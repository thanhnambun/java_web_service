package java.ra.ss7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.ra.ss7.entity.Seed;
import java.ra.ss7.repository.SeedRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SeedServiceImp implements SeedService {

    @Autowired
    private SeedRepository seedRepository;

    @Override
    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public Seed getSeedById(Long id) {
        return seedRepository.findById(id).get();
    }

    @Override
    public Seed addSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    @Override
    public Seed updateSeed(Long id, Seed seed) {
        seedRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tìm thấy hạt giống có id đó "));
        seed.setId(id);
        return seedRepository.save(seed);
    }

    @Override
    public void deleteSeed(Long id) {
        seedRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tìm thấy hạt giống có id đó "));
        seedRepository.deleteById(id);
    }
}