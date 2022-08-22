package com.portfolio.pds.Service;

import com.portfolio.pds.Entity.Hyss;
import com.portfolio.pds.Repository.RHyss;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHyss {
    @Autowired
    RHyss rHyss;
    
    public List<Hyss> list(){
        return rHyss.findAll();
    }
    
    public Optional<Hyss> getOne(int id){
        return rHyss.findById(id);
    }
    
    public Optional<Hyss> getByNombreH(String nombreH){
        return rHyss.findByNombreH(nombreH);
    }
    
    public void save(Hyss hyss){
        rHyss.save(hyss);
    }
    
    public void delete(int id){
        rHyss.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHyss.existsById(id);
    }
    
    public boolean existsByNombreH(String nombreH){
        return rHyss.existsByNombreH(nombreH);
    }
}
