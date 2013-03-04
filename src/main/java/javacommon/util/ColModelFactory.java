package javacommon.util;

import static org.apache.commons.digester3.binder.DigesterLoader.newLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.yunwei.order.controller.colmodel.ColModelList;

public class ColModelFactory {

	private final String colModelPath;

	private final ResourceLoader resourceLoader;
	
	private final ConcurrentLinkedHashMap<String, ColModelList> colModelCache;

	private final DigesterLoader digesterLoader = newLoader(new FromAnnotationsRuleModule() {
		@Override
		protected void configureRules() {
			bindRulesFrom(ColModelList.class);
		}
	});

	public ColModelFactory(String colModelPath, ResourceLoader resourceLoader,int capacity) {
		super();
		this.colModelPath = colModelPath;
		if (resourceLoader == null) {
			this.resourceLoader = new DefaultResourceLoader();
		} else {
			this.resourceLoader = resourceLoader;
		}
		colModelCache = new ConcurrentLinkedHashMap.Builder<String, ColModelList>().maximumWeightedCapacity(capacity).build();
	}

	public ColModelList getColModel(String modelxml)
			throws FileNotFoundException, IOException, SAXException {
		ColModelList result = null;
		if ((result = colModelCache.get(modelxml)) == null) {
			Digester digester = digesterLoader.newDigester();
			Resource resource = resourceLoader.getResource(colModelPath.concat(modelxml));
			ColModelList colModelList = (ColModelList) digester.parse(resource.getInputStream());
			result = colModelCache.putIfAbsent(modelxml, colModelList);
			result = (result == null ? colModelList : result);
		}
		  System.out.println("Weighed size = " + colModelCache.weightedSize());
		  System.out.println("Capacity = " + colModelCache.capacity());
		return result;
	}
	

	 /**
	 * @param args
	 */
	 public static void main(String[] args) {
	 try {
	 new
	 ColModelFactory("com/yunwei/order/controller/colmodel/",null,4).getColModel("category-colmodel.xml");
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 } catch (IOException e) {
	 e.printStackTrace();
	 } catch (SAXException e) {
	 e.printStackTrace();
	 }
	
	 }

}
