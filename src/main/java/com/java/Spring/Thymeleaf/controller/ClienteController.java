package com.java.Spring.Thymeleaf.controller;

import com.java.Spring.Thymeleaf.model.Cliente;
import com.java.Spring.Thymeleaf.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarCliente(Model model){
        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("cliente",clientes);
        return "clientes/listar";
    }

    @GetMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente){
        clienteService.save(cliente);
        return "redirect:clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        model.addAttribute("aluno", cliente);
        return "clientes/form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        clienteService.atualizarCliente(id, cliente);
        return "redirect:/clientes";
    }


    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes";
    }
}
