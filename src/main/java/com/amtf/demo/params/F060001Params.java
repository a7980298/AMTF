package com.amtf.demo.params;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.amtf.demo.f060001entity.f060001_select1entity;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter

public class F060001Params {
	List<f060001_select1entity> select1;
}
