package com.example.cad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cad.entity.Medicamentos;
import com.example.cad.service.MedicamentosService;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {

    @Autowired
    private MedicamentosService medicamentosService;

    @GetMapping
    public List<Medicamentos> listar() {
        return medicamentosService.buscarTodosMedicamentos();
    }

    @PostMapping
    public Medicamentos adicionar(@RequestBody Medicamentos medicamentos) {
        return medicamentosService.salvar(medicamentos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        medicamentosService.deletar(id);
    }

    @GetMapping("/{id}")
    public Medicamentos buscarPorId(@PathVariable Long id) {
        return medicamentosService.buscarMedicamentoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamentos> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamentos medicamentos) {
        Medicamentos medicamentoAtualizado = medicamentosService.atualizarMedicamento(id, medicamentos);
        if (medicamentoAtualizado != null) {
            return ResponseEntity.ok(medicamentoAtualizado);
        } else {
            return null;
        }
    }
}