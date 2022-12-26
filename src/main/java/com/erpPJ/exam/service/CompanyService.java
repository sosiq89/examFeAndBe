package com.erpPJ.exam.service;

import com.erpPJ.exam.model.CompanyVO;
import com.erpPJ.exam.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
  private final CompanyRepository companyRepository;

  public void companyNew(CompanyVO companyVO) {
    companyRepository.save(companyVO);
  }

  public List<CompanyVO> companyList(String searchWord) {
    List<CompanyVO> companyLists = new ArrayList<CompanyVO>();
    if(searchWord.equals(null) || searchWord.trim().isEmpty()){
      companyLists = companyRepository.findAll();
    }else{
      companyLists = companyRepository.findByName(searchWord);
    }
    return companyLists;
  }

  public void delCompany(long companyId) {
    companyRepository.deleteById(companyId);
  }

  public void companyEdit(CompanyVO companyVO) {
    CompanyVO companyOri = new CompanyVO();

    companyOri = companyRepository.findByCompany(companyVO.getCompanyId());

    companyOri.setCate(companyVO.getCate());
    companyOri.setName(companyVO.getName());
    companyOri.setManager(companyVO.getManager());
    companyOri.setLocation(companyVO.getLocation());

  }
}
