package com.opzero.util;

import com.opzero.entity.Offering;
import com.opzero.entity.dto.MasterDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MapperUtil {

    @Autowired
    ModelMapper modelMapper;

    @PostConstruct
    public void createMappers(){
        TypeMap<MasterDTO, Offering> masterToOfferingType=this.modelMapper.createTypeMap(MasterDTO.class, Offering.class);
        masterToOfferingType.addMapping(MasterDTO::getForeignKeyId, Offering::setOfferingPortfolioId);
        masterToOfferingType.addMapping(MasterDTO::getName, Offering::setOfferingName);
        TypeMap<Offering, MasterDTO> offeringToMasterType=this.modelMapper.createTypeMap(Offering.class, MasterDTO.class);
        offeringToMasterType.addMapping(Offering::getOfferingPortfolioId, MasterDTO::setForeignKeyId);
        offeringToMasterType.addMapping(Offering::getOfferingName, MasterDTO::setName);
    }
}
