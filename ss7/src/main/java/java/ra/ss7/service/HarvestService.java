package java.ra.ss7.service;

import java.ra.ss7.entity.Harvest;
import java.util.List;

public interface HarvestService {
    List<Harvest> getAllHarvests();
    Harvest getHarvestById(Long id);
    Harvest addHarvest(Harvest harvest);
}