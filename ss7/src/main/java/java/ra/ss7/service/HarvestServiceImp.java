package java.ra.ss7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.ra.ss7.entity.Harvest;
import java.ra.ss7.repository.HarvestRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HarvestServiceImp implements HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Override
    public List<Harvest> getAllHarvests() {
        return harvestRepository.findAll();
    }

    @Override
    public Harvest getHarvestById(Long id) {
        return harvestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy thông tin thu hoạch có id: " + id));
    }

    @Override
    public Harvest addHarvest(Harvest harvest) {
        return harvestRepository.save(harvest);
    }
}