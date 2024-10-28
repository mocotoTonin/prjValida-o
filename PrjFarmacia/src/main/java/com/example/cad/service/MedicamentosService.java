package com.example.cad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cad.entity.Medicamentos;
import com.example.cad.repository.MedicamentosRepository;

@Service
public class MedicamentosService {

    private final MedicamentosRepository medicamentosRepository;

    @Autowired
    public MedicamentosService(MedicamentosRepository medicamentosRepository) {
        this.medicamentosRepository = medicamentosRepository;
    }

    public Medicamentos salvar(Medicamentos medicamentos) {
        return medicamentosRepository.save(medicamentos);
    }

    public void deletar(Long id) {
        medicamentosRepository.deleteById(id);
    }

    public Medicamentos buscarMedicamentoPorId(Long id) {
        return medicamentosRepository.findById(id).orElse(null);
    }

    public List<Medicamentos> buscarTodosMedicamentos() {
        return medicamentosRepository.findAll();
    }

    public Medicamentos atualizarMedicamento(Long id, Medicamentos medicamentosAtualizado) {
        Optional<Medicamentos> medicamentosExistente = medicamentosRepository.findById(id);
        if (medicamentosExistente.isPresent()) {
            Medicamentos medicamentos = medicamentosExistente.get();
            medicamentos.setNome(medicamentosAtualizado.getNome());
            medicamentos.setBula(medicamentosAtualizado.getBula());
            medicamentos.setIdfornecedor(medicamentosAtualizado.getIdfornecedor());
            medicamentos.setDataValidade(medicamentosAtualizado.getDataValidade());
            return medicamentosRepository.save(medicamentos);
        } else {
            return null;
        }
    }
}
