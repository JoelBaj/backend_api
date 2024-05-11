package com.back_api.backend_api.services.impl;

import com.back_api.backend_api.Util.JsonSchemaLoader;
import com.back_api.backend_api.Util.MessageUtil;
import com.back_api.backend_api.Util.ResponseData;
import com.back_api.backend_api.model.Dto.UsuarioDTO;
import com.back_api.backend_api.model.entity.Usuario;
import com.back_api.backend_api.model.repository.UsuarioRepository;
import com.back_api.backend_api.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsuarioImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    //private final JsonSchema userSchema;
    private final ObjectMapper objectMapper;

    @Autowired
    public UsuarioImp(ObjectMapper objectMapper) throws Exception {
        //this.userSchema = JsonSchemaLoader.loadSchemaFromInputStream(getClass().getResourceAsStream("/json/client-schema.json"));
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseData findAll() {
        ResponseData response = new ResponseData();
        Map<String, Object> mapUsuario = new HashMap<>();
        try {
            List<Usuario> listusuario = usuarioRepository.findAll();
            if (!listusuario.isEmpty()) {
                List<UsuarioDTO> listUsuarioDto = listusuario.stream()
                        // .map(this::convertToDTO)
                        .map(this::convertToDTO01)
                        .collect(Collectors.toList());
                mapUsuario.put("listusuarios", listUsuarioDto);
                response.setData(mapUsuario);
                response.setCode(MessageUtil.OK.name());
                response.setMessage(MessageUtil.OK.getKey());
            } else {
                response.setCode(MessageUtil.NOTFOUND.name());
                response.setMessage(MessageUtil.NOTFOUND.getKey());
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(MessageUtil.ERRORCONSULTA.name());
            response.setMessage(MessageUtil.ERRORCONSULTA.getKey() + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseData findById(Integer id) {
        return null;
    }

    @Override
    public ResponseData save(Usuario usuario, Integer id) {
        return null;
    }

    @Override
    public ResponseData saveCargaMasiva(String Json, Integer accion) {
        return null;
    }

    @Override
    public ResponseData eliminarUsuario(Integer idUsuario) {
        return null;
    }
    private UsuarioDTO convertToDTO01(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class); // Si estás utilizando ModelMapper
    }
    @Override
    public ResponseData buscaridentificaccion(String identification) {
        return null;
    }
}
