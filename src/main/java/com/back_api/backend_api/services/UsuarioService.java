package com.back_api.backend_api.services;

import com.back_api.backend_api.Util.ResponseData;
import com.back_api.backend_api.model.entity.Usuario;
import com.back_api.backend_api.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public interface UsuarioService {
    public ResponseData findAll();
    public ResponseData findById(Integer id) ;
    public ResponseData save(Usuario usuario,Integer id) ;

    public ResponseData saveCargaMasiva(String Json, Integer accion) ;

    public ResponseData  eliminarUsuario(Integer idUsuario);
    public ResponseData  buscaridentificaccion(String identification);


}
