package com.mercadolibre.showroom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.showroom.dto.request.PrendaDetalleRequestDto;
import com.mercadolibre.showroom.dto.request.VentaRequestDto;
import com.mercadolibre.showroom.dto.response.DetalleVentaDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.dto.response.VentaResponseDto;
import com.mercadolibre.showroom.exception.BadRequest;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import com.mercadolibre.showroom.repository.DetalleVentaRepository;
import com.mercadolibre.showroom.repository.VentaRepository;
import com.mercadolibre.showroom.utils.GlobalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VentaService implements IVentaService{
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final IPrendaService prendaService;

    @Override
    public VentaResponseDto addVenta(VentaRequestDto ventaRequest){

        if(existByNumero(ventaRequest.getNumero())){
            throw new BadRequest("Ya hay una venta con ese numero: " + ventaRequest.getNumero());
        }

        Venta venta = GlobalMapper.ventaDtoToentity(ventaRequest, getPrendaByCodigo(ventaRequest));
        ventaRepository.save(venta);

        return GlobalMapper.ventaEntityToDto(venta);
    }

    @Override
    public List<VentaResponseDto> getAllVentas(){
        List<Venta> ventas = ventaRepository.findAll();
        if(ventas.isEmpty()){
            throw new BadRequest("No hay ventas");
        }

        return GlobalMapper.ventaListEntityToDto(ventas);
    }

    @Override
    public VentaResponseDto getByNumero(String numero){
        return GlobalMapper.ventaEntityToDto(
                findByNumero(numero)
        );
    }

    @Override
    public VentaResponseDto updateVenta(String numero, VentaRequestDto ventaRequest){
        Venta ventaDb = findByNumero(numero);
        List<Prenda> prendas = getPrendaByCodigo(ventaRequest);

        Venta ventaToSave = GlobalMapper.ventaUpdateEntityFromDto(ventaDb, ventaRequest, prendas);
        ventaRepository.save(ventaToSave);

        return GlobalMapper.ventaEntityToDto(ventaDb);
    }

    @Override
    public void deleteVenta(String numero){
        Venta ventaDb = findByNumero(numero);
        ventaRepository.deleteById(ventaDb.getId());
    }

    @Override
    public List<VentaResponseDto> getByDate(LocalDate fecha){
        List<Venta> ventas = findByFecha(fecha);
        if(ventas.isEmpty()){
            throw new BadRequest("No se encontraron ventas con esa fecha");
        }

        return GlobalMapper.ventaListEntityToDto(ventas);
    }

    @Override
    public List<PrendaResponseDto> findPrendaFromVenta(String numero){
        List<Prenda> prendas = detalleVentaRepository.findPrendasByVentaNumero(numero);
        if(prendas.isEmpty()){
            throw new BadRequest("No se encontro venta");
        }

        return GlobalMapper.listEntityToDto(prendas);
    }


    /*+++++++++++++++
     PRIVATE METHODS
    ++++++++++++++++*/

    private boolean existByNumero(String numero){
        return ventaRepository.existsByNumero(numero);
    }

    private Venta findByNumero(String numero){
        return ventaRepository.findByNumero(numero)
                .orElseThrow(()-> new BadRequest("No existe venta con ese numero: "+ numero));
    }

    private List<Venta> findByFecha(LocalDate fecha){
        return ventaRepository.findAllByFecha(fecha);
    }

    private List<Prenda> getPrendaByCodigo(VentaRequestDto venta){
        List<Prenda> prendaList = new ArrayList<>();

        for (PrendaDetalleRequestDto prenda : venta.getPrendas()){
            prendaList.add(prendaService.findByCodigo(prenda.getCodigo()));
        }
        return prendaList;
    }
}
