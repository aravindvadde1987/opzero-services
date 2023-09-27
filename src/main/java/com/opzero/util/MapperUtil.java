package com.opzero.util;

import com.opzero.entity.*;
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
        //offering
        TypeMap<MasterDTO, Offering> masterToOfferingType=this.modelMapper.createTypeMap(MasterDTO.class, Offering.class);
        masterToOfferingType.addMapping(MasterDTO::getParentId, Offering::setOfferingPortfolioId);
        masterToOfferingType.addMapping(MasterDTO::getName, Offering::setOfferingName);
        TypeMap<Offering, MasterDTO> offeringToMasterType=this.modelMapper.createTypeMap(Offering.class, MasterDTO.class);
        offeringToMasterType.addMapping(Offering::getOfferingPortfolioId, MasterDTO::setParentId);
        offeringToMasterType.addMapping(Offering::getOfferingName, MasterDTO::setName);

        //account
        TypeMap<MasterDTO, Account> masterToAccountType=this.modelMapper.createTypeMap(MasterDTO.class, Account.class);
        masterToAccountType.addMapping(MasterDTO::getParentId, Account::setOfferingId);
        masterToAccountType.addMapping(MasterDTO::getName, Account::setAccountName);
        TypeMap<Account, MasterDTO> AccountToMasterType=this.modelMapper.createTypeMap(Account.class, MasterDTO.class);
        AccountToMasterType.addMapping(Account::getOfferingId, MasterDTO::setParentId);
        AccountToMasterType.addMapping(Account::getAccountName, MasterDTO::setName);

        //Category
        TypeMap<MasterDTO, Category> masterToCategoryType=this.modelMapper.createTypeMap(MasterDTO.class, Category.class);
        masterToCategoryType.addMapping(MasterDTO::getName, Category::setCategoryName);
        TypeMap<Category, MasterDTO> categoryToMasterType=this.modelMapper.createTypeMap(Category.class, MasterDTO.class);
        categoryToMasterType.addMapping(Category::getCategoryName, MasterDTO::setName);
        categoryToMasterType.addMapping(Category::getLevers, MasterDTO::setChildrens);

        //Lever
        TypeMap<MasterDTO, Lever> masterToLeverType=this.modelMapper.createTypeMap(MasterDTO.class, Lever.class);
        masterToLeverType.addMapping(MasterDTO::getName, Lever::setLeverName);
        TypeMap<Lever, MasterDTO> leverToMasterType=this.modelMapper.createTypeMap(Lever.class, MasterDTO.class);
        leverToMasterType.addMapping(lever -> lever.getCategory().getId(), MasterDTO::setParentId);

        leverToMasterType.addMapping(Lever::getLeverName, MasterDTO::setName);

        //Offering Portfolio
        TypeMap<MasterDTO, OfferingPortfolio> masterToOfferingPortfolioType=this.modelMapper.createTypeMap(MasterDTO.class, OfferingPortfolio.class);
        masterToOfferingPortfolioType.addMapping(MasterDTO::getName, OfferingPortfolio::setOfferingPortfolioName);
        TypeMap<OfferingPortfolio, MasterDTO> offeringPortfolioToMasterType=this.modelMapper.createTypeMap(OfferingPortfolio.class, MasterDTO.class);
        offeringPortfolioToMasterType.addMapping(OfferingPortfolio::getOfferingPortfolioName, MasterDTO::setName);

        //Project
        TypeMap<MasterDTO, Project> masterToProjectType=this.modelMapper.createTypeMap(MasterDTO.class, Project.class);
        masterToProjectType.addMapping(MasterDTO::getParentId, Project::setAccountId);
        masterToProjectType.addMapping(MasterDTO::getName, Project::setProjectName);
        TypeMap<Project, MasterDTO> projectToMasterType=this.modelMapper.createTypeMap(Project.class, MasterDTO.class);
        projectToMasterType.addMapping(Project::getAccountId, MasterDTO::setParentId);
        projectToMasterType.addMapping(Project::getProjectName, MasterDTO::setName);

        //Data Detail
        TypeMap<MasterDTO, DataDetail> masterDTODataDetailTypeMapType=this.modelMapper.createTypeMap(MasterDTO.class, DataDetail.class);
        masterDTODataDetailTypeMapType.addMapping(MasterDTO::getChildrens, DataDetail::setSolutionDetails);
        TypeMap<DataDetail, MasterDTO> dataDetailMasterDTOTypeMapToMasterType=this.modelMapper.createTypeMap(DataDetail.class, MasterDTO.class);
        dataDetailMasterDTOTypeMapToMasterType.addMapping(DataDetail::getSolutionDetails, MasterDTO::setChildrens);
    }
}
