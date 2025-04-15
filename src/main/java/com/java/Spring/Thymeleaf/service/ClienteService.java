package com.java.Spring.Thymeleaf.service;

import com.java.Spring.Thymeleaf.model.Cliente;
import com.java.Spring.Thymeleaf.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientRepository;

    public Cliente save (Cliente cliente){
        return clientRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clientRepository.findAll();
    }

    public Optional<Cliente> buscarId(Long id){
        return clientRepository.findById(id);
    }
    public void deletar( Long id){
        clientRepository.deleteById(id);
    }

    //atualizar

    public Cliente atualizarCliente(Long id,Cliente clienteAtualizado){
        return clientRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setIdade(clienteAtualizado.getIdade());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    return clientRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

}
