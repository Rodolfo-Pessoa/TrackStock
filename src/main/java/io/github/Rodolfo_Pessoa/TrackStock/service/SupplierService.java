package io.github.Rodolfo_Pessoa.TrackStock.service;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Supplier;
import io.github.Rodolfo_Pessoa.TrackStock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }
    public boolean deleteById(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
