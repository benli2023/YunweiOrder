package com.yunwei.order.model.grid;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.Assert;

import junit.framework.TestCase;

public class EditorGridTest extends TestCase {
	
	private String jsonContent="{\"update\":[{\"stockOperationId\":1,\"stockOperDetailId\":1,\"productId\":\"5\",\"stockOperationIdTxt\":\"出库\",\"productIdTxt\":\"7544\",\"haveInvoice\":1,\"invoiceNumber\":\"121212121\",\"price\":12,\"quantity\":12}],\"insert\":[{\"productId\":\"8\",\"productIdTxt\":\"商品名称\",\"price\":\"112\",\"quantity\":\"12\",\"haveInvoice\":\"\",\"invoiceNumber\":\"111\"}],\"delete\":[]}";
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	
	public void testStockLineGridData() {
		StockRecordLineEditorData  data=null;
		try {
			data=objectMapper.readValue(jsonContent, StockRecordLineEditorData.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.notNull(data);
		
	}
	
	

}
