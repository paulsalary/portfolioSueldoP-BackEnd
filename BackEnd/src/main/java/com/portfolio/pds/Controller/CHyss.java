package com.portfolio.pds.Controller;

import com.portfolio.pds.Dto.dtoHyss;
import com.portfolio.pds.Entity.Hyss;
import com.portfolio.pds.Security.Controller.Mensaje;
import com.portfolio.pds.Service.SHyss;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hyss")
@CrossOrigin(origins = "https://frontendpds.web.app")
public class CHyss {
    @Autowired
    SHyss sHyss;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hyss>> list(){
        List<Hyss> list = sHyss.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hyss> getById(@PathVariable("id") int id){
        if(!sHyss.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hyss hyss = sHyss.getOne(id).get();
        return new ResponseEntity(hyss, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHyss.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHyss.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyss dtohyss){      
        if(StringUtils.isBlank(dtohyss.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHyss.existsByNombreH(dtohyss.getNombreH()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Hyss hyss = new Hyss (dtohyss.getNombreH(), dtohyss.getDescripcionE(), dtohyss.getIconoH());
        sHyss.save(hyss);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyss dtohyss){
        //Validamos si existe el ID
        if(!sHyss.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sHyss.existsByNombreH(dtohyss.getNombreH()) && sHyss.getByNombreH(dtohyss.getNombreH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtohyss.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hyss hyss = sHyss.getOne(id).get();
        hyss.setNombreH(dtohyss.getNombreH());
        hyss.setDescripcionE((dtohyss.getDescripcionE()));
        hyss.setIconoH(dtohyss.getIconoH());
        
        sHyss.save(hyss);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}