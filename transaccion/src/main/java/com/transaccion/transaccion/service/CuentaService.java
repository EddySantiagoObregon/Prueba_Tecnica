package com.transaccion.transaccion.service;

import com.transaccion.transaccion.dtos.ClienteDTO;
import com.transaccion.transaccion.dtos.CuentaDTO;
import com.transaccion.transaccion.dtos.MovimientoDTO;
import com.transaccion.transaccion.entity.CuentaEntity;
import com.transaccion.transaccion.entity.MovimientoEntity;
import com.transaccion.transaccion.exception.BadRequestException;
import com.transaccion.transaccion.exception.NotFoundException;
import com.transaccion.transaccion.repository.CuentaRepository;
import com.transaccion.transaccion.repository.MovimientoRepository;
import com.transaccion.transaccion.utils.UtilsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;
    @Autowired
    ApiService apiService;


    public CuentaEntity obtenerCuenta(long NumeroCuenta) throws BadRequestException {
        Optional<CuentaEntity> cuentaOptional=cuentaRepository.findByNoCuenta(NumeroCuenta);

        if (cuentaOptional.isEmpty()){
            throw new BadRequestException("No Se encontro una cuenta con el numero: "+String.valueOf(NumeroCuenta));
        }
        //CuentaEntity cuenta=cuentaOptional.get();
        return cuentaRepository.findByNoCuenta(NumeroCuenta).get();
    }

    public CuentaEntity crearCuenta(CuentaEntity cuenta){
        return cuentaRepository.save(cuenta);
    }


    public ClienteDTO clienteReporte(Date fechaInicio, Date fechaFinal, long clienteId) throws BadRequestException, NotFoundException {
        UtilsMapper utilsMapper=new UtilsMapper();


        ClienteDTO cliente=apiService.getDataCliente(String.valueOf(clienteId));


        List<CuentaEntity> cuentas=cuentaRepository.findAllByClienteId(clienteId);
        List<CuentaDTO> cuentasDto=new ArrayList<>();
        cuentas.forEach(cuenta -> cuentasDto.add(utilsMapper.mapCuentasToDTO(cuenta)));

        for (int i=0;i<cuentas.size();i++){
            List<MovimientoDTO> movimientoDTO=new ArrayList<>();
            List<MovimientoEntity> movimientoEntityList=new ArrayList<>();
            movimientoEntityList=movimientoRepository.findAllByCuentaAndFechaBetween(cuentas.get(i), fechaInicio, fechaFinal);
            movimientoEntityList.forEach(movimiento -> movimientoDTO.add(utilsMapper.mapMovimientoToDto(movimiento)));
            cuentasDto.get(i).setMovimientos(movimientoDTO);
        }
        cliente.setCuentas(cuentasDto);

        return cliente;
    }

    public void modificarCuenta(long idCuenta, CuentaEntity cuenta){

    }
}
