package com.erpPJ.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name="company")
public class CompanyVO {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long companyId;
  private String name;
  private String cate;
  private String manager;
  private String location;


}
