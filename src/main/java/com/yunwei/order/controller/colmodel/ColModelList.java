package com.yunwei.order.controller.colmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;



public class ColModelList implements Serializable,Cloneable {

	private static final long serialVersionUID = -857303626203853929L;

	private final String modelId;

	private final List<ColModel> colModels = new ArrayList<ColModel>(5);

	@ObjectCreate(pattern = "column-models")
	public ColModelList( @CallParam( pattern = "column-models", attributeName = "id" ) String modelId) {
		super();
		this.modelId = modelId;
	}

	public String getModelId() {
		return modelId;
	}

	public List<ColModel> getColModels() {
		return colModels;
	}
	@SetNext()
	public void addModel(ColModel colModel) {
		colModels.add(colModel);
	}

}
